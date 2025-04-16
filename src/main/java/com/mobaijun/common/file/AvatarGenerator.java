/*
 * Copyright (C) 2022 [www.mobaijun.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mobaijun.common.file;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Random;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import lombok.extern.slf4j.Slf4j;

/**
 * Description: [根据用户名生成头像]
 * Author: [mobaijun]
 * Date: [2024/10/11 12:09]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
@Slf4j
public class AvatarGenerator {

    // 常量定义
    private static final int WIDTH = 100;
    private static final int HEIGHT = 100;
    private static final int CORNER_RADIUS = 99;
    private static final String[] BEAUTIFUL_COLORS = {
            "232,221,203", "205,179,128", "3,101,100", "3,54,73", "3,22,52",
            "237,222,139", "251,178,23", "96,143,159", "1,77,103", "254,67,101",
            "252,157,154", "249,205,173", "200,200,169", "131,175,155",
            "229,187,129", "161,23,21", "34,8,7", "118,77,57", "17,63,61",
            "60,79,57", "95,92,51", "179,214,110", "248,147,29", "227,160,93", "178,190,126"
    };

    /**
     * 【原版方法】生成PNG格式头像Base64
     * （保持与现有代码完全兼容）
     */
    public static String generateImg(String name) {
        BufferedImage image = generateAvatarImage(name);
        return toBase64(image);
    }

    /**
     * 【原版方法】Base64转临时文件
     */
    public static File base64ToTempFile(String base64Img) throws IOException {
        String[] base64Parts = base64Img.split(",");
        String base64Data = base64Parts.length > 1 ? base64Parts[1] : base64Parts[0];
        byte[] imgBytes = Base64.getDecoder().decode(base64Data);

        File tempFile = File.createTempFile("temp_image_", ".png");
        tempFile.deleteOnExit();

        try (OutputStream out = new FileOutputStream(tempFile)) {
            out.write(imgBytes);
        }
        return tempFile;
    }

    /**
     * 【优化版】生成WebP格式头像Base64（推荐新功能使用）
     * 体积比PNG减少60%以上
     */
    public static String generateOptimizedAvatar(String name) {
        BufferedImage image = generateAvatarImage(name);
        return toBase64(image, "webp", 0.8f);
    }

    /**
     * 【优化版】生成指定质量的WebP头像
     *
     * @param quality 0.1-1.0 质量参数
     */
    public static String generateOptimizedAvatar(String name, float quality) {
        BufferedImage image = generateAvatarImage(name);
        return toBase64(image, "webp", quality);
    }

    /**
     * 核心方法：生成头像图片对象（原版和优化版共用）
     */
    private static BufferedImage generateAvatarImage(String name) {
        String nameWritten = processName(name);
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = createGraphics(image);
        drawName(g2, nameWritten);
        g2.dispose();
        return makeRoundedCorner(image);
    }

    /**
     * 通用Base64转换方法（支持多种格式）
     */
    private static String toBase64(BufferedImage image) {
        return toBase64(image, "png", 1.0f);
    }

    /**
     * 通用Base64转换方法（支持质量参数）
     */
    private static String toBase64(BufferedImage image, String format, float quality) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            if ("webp".equalsIgnoreCase(format)) {
                // WebP特殊处理（需要压缩）
                ImageWriter writer = ImageIO.getImageWritersByMIMEType("image/webp").next();
                ImageWriteParam writeParam = writer.getDefaultWriteParam();
                writeParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                writeParam.setCompressionQuality(quality);

                try (ImageOutputStream ios = ImageIO.createImageOutputStream(baos)) {
                    writer.setOutput(ios);
                    writer.write(null, new IIOImage(image, null, null), writeParam);
                }
            } else {
                // 其他格式直接写入
                ImageIO.write(image, format, baos);
            }
            return "data:image/" + format.toLowerCase() + ";base64," +
                    Base64.getEncoder().encodeToString(baos.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("生成Base64失败", e);
        }
    }

    /**
     * 处理显示名称的规则：
     * 1. 长度≤2：直接显示全部字符
     * 2. 中文名：显示最后两个汉字
     * 3. 英文名：显示首字母大写
     *
     * @param name 需要处理的原始姓名
     * @return 处理后的显示名称（1-2个字符）
     */
    private static String processName(String name) {
        int length = name.length();
        if (length <= 2) return name;
        return isChinese(name.charAt(0)) ? name.substring(length - 2) : name.substring(0, 1).toUpperCase();
    }

    /**
     * 创建并初始化图形上下文
     *
     * @param image 需要绘制的图像对象
     * @return 配置完成的Graphics2D对象，已设置：
     * - 抗锯齿渲染
     * - 随机背景色
     * - 白色前景色
     * - 清除画布
     */
    private static Graphics2D createGraphics(BufferedImage image) {
        Graphics2D g2 = image.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setBackground(getRandomColor());
        g2.clearRect(0, 0, WIDTH, HEIGHT);
        g2.setColor(Color.WHITE);
        return g2;
    }

    /**
     * 在图像上绘制处理后的名称
     *
     * @param g2          图形上下文对象
     * @param nameWritten 经过processName处理后的名称（1-2个字符）
     */
    private static void drawName(Graphics2D g2, String nameWritten) {
        Font font = new Font("微软雅黑", Font.PLAIN, nameWritten.length() == 2 ? 30 : 50);
        g2.setFont(font);
        if (nameWritten.length() == 2) {
            drawTwoChars(g2, nameWritten);
        } else {
            drawSingleChar(g2, nameWritten);
        }
    }

    /**
     * 绘制两个字符（精确控制不同字符组合的显示位置）
     *
     * @param g2   图形上下文对象
     * @param name 需要绘制的两个字符（可能组合：中文+中文/中文+英文/英文+英文）
     */
    private static void drawTwoChars(Graphics2D g2, String name) {
        boolean firstChinese = isChinese(name.charAt(0));
        boolean secondChinese = isChinese(name.charAt(1));
        // 动态调整X坐标：
        // - 两个中文：20px
        // - 首中次英：27px
        // - 其他英文组合：30px
        int x = firstChinese ? (secondChinese ? 20 : 27) : 30;
        g2.drawString(name, x, 60); // Y轴固定60px
    }

    /**
     * 绘制单个字符（精确控制中英文显示位置）
     *
     * @param g2   图形上下文对象
     * @param name 需要绘制的单个字符
     */
    private static void drawSingleChar(Graphics2D g2, String name) {
        // 中文和英文使用不同的坐标
        int x = isChinese(name.charAt(0)) ? 25 : 33;
        int y = isChinese(name.charAt(0)) ? 70 : 67;
        g2.drawString(name, x, y);
    }

    /**
     * 从预定义颜色数组中获取随机颜色
     *
     * @return 随机生成的Color对象，颜色来自BEAUTIFUL_COLORS预设值
     * @see #BEAUTIFUL_COLORS
     */
    private static Color getRandomColor() {
        String[] color = BEAUTIFUL_COLORS[new Random().nextInt(BEAUTIFUL_COLORS.length)].split(",");
        return new Color(Integer.parseInt(color[0]), Integer.parseInt(color[1]), Integer.parseInt(color[2]));
    }

    /**
     * 对图像进行圆角处理
     *
     * @param image 原始方形图像
     * @return 带圆角效果的图像（圆角半径99px）
     */
    private static BufferedImage makeRoundedCorner(BufferedImage image) {
        BufferedImage output = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = output.createGraphics();
        g2.setComposite(AlphaComposite.Src);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fill(new RoundRectangle2D.Float(0, 0, WIDTH, HEIGHT, CORNER_RADIUS, CORNER_RADIUS));
        g2.setComposite(AlphaComposite.SrcAtop);
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return output;
    }

    /**
     * 判断字符是否为中文
     *
     * @param c 需要判断的字符
     * @return true表示是中文字符（Unicode范围：\u4e00-\u9fa5）
     */
    private static boolean isChinese(char c) {
        return String.valueOf(c).matches("[\\u4e00-\\u9fa5]");
    }
}