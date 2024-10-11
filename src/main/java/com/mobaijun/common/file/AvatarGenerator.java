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
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import lombok.extern.slf4j.Slf4j;

/**
 * Description: [根据用户名生成头像]
 * Author: [mobaijun]
 * Date: [2024/10/11 12:09]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
@Slf4j
public class AvatarGenerator {

    /**
     * 生成头像图片，如果是英文名只显示首字母大写，如果是中文名只显示最后两个字。
     * 返回头像图片的Base64字符串。
     *
     * @param name 用户的姓名
     * @return 图片的Base64字符串
     */
    public static String generateImg(String name) {
        // 图像宽高设置
        int width = 100;
        int height = 100;
        int nameLength = name.length();
        String nameWritten;

        // 使用 switch 表达式简化对名字的处理逻辑
        nameWritten = switch (nameLength) {
            case 1, 2 -> name; // 如果名字长度为1或2，则直接显示全部
            default -> {
                if (isChinese(name.substring(0, 1))) {
                    // 如果是中文名，则截取倒数两位汉字
                    yield name.substring(nameLength - 2);
                } else {
                    // 如果是英文名，则显示首字母并转换为大写
                    yield name.substring(0, 1).toUpperCase();
                }
            }
        };

        // 创建图像对象并设置背景颜色
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bufferedImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        // 随机颜色
        g2.setBackground(getRandomColor());
        // 清除矩形
        g2.clearRect(0, 0, width, height);
        // 设置字体颜色为白色
        g2.setPaint(Color.WHITE);

        // 设置字体及字体大小（根据字符长度动态调整）
        Font font = new Font("微软雅黑", Font.PLAIN, nameWritten.length() == 2 ? 30 : 50);
        g2.setFont(font);

        // 判断字符数量，调用不同的方法绘制
        if (nameWritten.length() == 2) {
            // 绘制两个字符
            drawTwoChars(g2, nameWritten);
        } else {
            // 绘制单个字符
            drawSingleChar(g2, nameWritten);
        }

        // 圆角处理
        bufferedImage = makeRoundedCorner(bufferedImage);

        // 返回Base64格式的图片字符串
        return toBase64(bufferedImage);
    }

    /**
     * 绘制两个字符的图像。
     *
     * @param g2          图像的绘制上下文
     * @param nameWritten 要绘制的两个字符
     */
    private static void drawTwoChars(Graphics2D g2, String nameWritten) {
        // 第一个字符
        String firstWritten = nameWritten.substring(0, 1);
        // 第二个字符
        String secondWritten = nameWritten.substring(1, 2);

        // 判断字符类型（中文或英文）并调整绘制位置
        if (isChinese(firstWritten) && isChinese(secondWritten)) {
            // 两个中文字符绘制
            g2.drawString(nameWritten, 20, 60);
        } else if (isChinese(firstWritten)) {
            // 第一个为中文，第二个为英文
            g2.drawString(nameWritten, 27, 60);
        } else {
            // 两个英文字符绘制
            g2.drawString(nameWritten, 30, 60);
        }
    }

    /**
     * 绘制单个字符的图像。
     *
     * @param g2          图像的绘制上下文
     * @param nameWritten 要绘制的单个字符
     */
    private static void drawSingleChar(Graphics2D g2, String nameWritten) {
        // 判断字符类型（中文或英文）并调整绘制位置
        if (isChinese(nameWritten)) {
            // 绘制中文字符
            g2.drawString(nameWritten, 25, 70);
        } else {
            // 绘制英文字符并转换为大写
            g2.drawString(nameWritten.toUpperCase(), 33, 67);
        }
    }

    /**
     * 获得随机颜色，从一组预定义的漂亮颜色中随机挑选。
     *
     * @return 随机生成的颜色对象
     */
    private static Color getRandomColor() {
        String[] beautifulColors = new String[]{"232,221,203", "205,179,128", "3,101,100",
                "3,54,73", "3,22,52", "237,222,139", "251,178,23", "96,143,159", "1,77,103",
                "254,67,101", "252,157,154", "249,205,173", "200,200,169", "131,175,155",
                "229,187,129", "161,23,21", "34,8,7", "118,77,57", "17,63,61", "60,79,57",
                "95,92,51", "179,214,110", "248,147,29", "227,160,93", "178,190,126"};

        // 从颜色数组中随机挑选一个颜色
        String[] color = beautifulColors[new Random().nextInt(beautifulColors.length)].split(",");
        return new Color(Integer.parseInt(color[0]), Integer.parseInt(color[1]), Integer.parseInt(color[2]));
    }

    /**
     * 检查字符串是否为中文字符。
     *
     * @param str 要检查的字符串
     * @return 如果是中文字符则返回true，否则返回false
     */
    private static boolean isChinese(String str) {
        return Pattern.compile("[\\u4e00-\\u9fa5]").matcher(str).find();
    }

    /**
     * 对图像进行圆角处理，生成带圆角的图像。
     *
     * @param image 原始图像
     * @return 处理后的带圆角的图像
     */
    private static BufferedImage makeRoundedCorner(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage output = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = output.createGraphics();

        // 设置图形的抗锯齿效果
        g2.setComposite(AlphaComposite.Src);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);

        // 绘制圆角矩形
        g2.fill(new RoundRectangle2D.Float(0, 0, w, h, 99, 99));
        g2.setComposite(AlphaComposite.SrcAtop);
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return output;
    }

    /**
     * 将BufferedImage图像转换为Base64编码的字符串。
     *
     * @param image 要转换的图像
     * @return 图像的Base64编码字符串
     */
    private static String toBase64(BufferedImage image) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            ImageIO.write(image, "png", outputStream);
            return "data:image/png;base64," + Base64.getEncoder().encodeToString(outputStream.toByteArray());
        } catch (IOException e) {
            log.error("生成Base64字符串失败：{}", e.getMessage());
            return null;
        }
    }

    /**
     * 将 Base64 字符串转换为临时文件
     *
     * @param base64Img Base64 编码的图片
     * @return File 对象（临时文件）
     * @throws IOException 如果解码或写入失败
     */
    public static File base64ToTempFile(String base64Img) throws IOException {
        // 去掉 Base64 编码中的头部信息
        String[] base64Parts = base64Img.split(",");
        String base64Data = base64Parts.length > 1 ? base64Parts[1] : base64Parts[0];

        // 解码 Base64 字符串
        byte[] imgBytes = Base64.getDecoder().decode(base64Data);

        // 创建临时文件
        File tempFile = File.createTempFile("temp_image_", ".png");
        // 在 JVM 退出时自动删除临时文件
        tempFile.deleteOnExit();

        // 写入文件
        try (OutputStream out = new FileOutputStream(tempFile)) {
            out.write(imgBytes);
        }

        return tempFile;
    }
}
