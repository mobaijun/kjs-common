/*
 * Copyright (C) 2022 www.mobaijun.com
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
package com.mobaijun.common.util.image;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.img.Img;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.log.Log;
import lombok.SneakyThrows;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: EnhanceImgUtils
 * class description: 增强图片处理工具类
 *
 * @author MoBaiJun 2022/11/23 21:16
 */
public class EnhanceImgUtils extends ImgUtil {

    /**
     * tools log
     */
    private static final Log log = Log.get(EnhanceImgUtils.class);

    /**
     * 判断文件是否是图片类型
     * 【注意】如果文件缺乏图片类型扩展名后缀则默认其是图片
     *
     * @param imagePath imagePath
     * @return boolean
     */
    public static boolean isImage(String imagePath) {
        return isImage(FileUtil.file(imagePath));
    }

    /**
     * 判断文件是否是图片类型
     * 【注意】如果文件缺乏图片类型扩展名后缀则默认其是图片
     *
     * @param image image
     * @return boolean
     */
    public static boolean isImage(File image) {
        if (FileUtil.isFile(image)) {
            return Optional.ofNullable(FileUtil.extName(image))
                    .map(fileExtName -> StrUtil.isBlank(fileExtName) || StrUtil.equalsAnyIgnoreCase(fileExtName,
                            EnhanceImgUtils.IMAGE_TYPE_JPG,
                            EnhanceImgUtils.IMAGE_TYPE_GIF, EnhanceImgUtils.IMAGE_TYPE_JPEG, EnhanceImgUtils.IMAGE_TYPE_BMP,
                            EnhanceImgUtils.IMAGE_TYPE_PNG, EnhanceImgUtils.IMAGE_TYPE_PSD))
                    .orElse(true);
        } else {
            return false;
        }
    }


    /**
     * 图片圆角处理（没啥用，原角是黑色的）
     *
     * @param arc   圆角弧度，0~1，为长宽占比
     * @param Image 图片
     */
    public static BufferedImage borderRadius(Image Image, double arc) {
        return (BufferedImage) Img.from(Image).round(arc).getImg();
    }

    /**
     * 生成纯色图片
     *
     * @param width  图片宽
     * @param height 图片高
     * @return BufferedImage
     */
    public static BufferedImage createPureColorImage(int width, int height) {
        return createPureColorImage(width, height, Color.white);
    }

    /**
     * 生成纯色图片
     *
     * @param width  图片宽
     * @param height 图片高
     * @param color  颜色  空则Color.BLACK
     * @return BufferedImage
     */
    public static BufferedImage createPureColorImage(int width, int height, Color color) {
        // width 生成图宽度
        // height 生成图高度
        // 创建一个width xheight ，RGB高彩图，类型可自定
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 取得图形
        Graphics g = img.getGraphics();
        // 设置颜色
        g.setColor(ObjectUtil.defaultIfNull(color, Color.white));
        // 填充
        g.fillRect(0, 0, img.getWidth(), img.getHeight());
        // 在d盘创建个文件
        return img;
    }

    /**
     * 生成文本图片
     *
     * @param content 文本
     * @param width   图片宽
     * @param height  图片高
     * @return BufferedImage
     */
    public static BufferedImage createContentImage(String content, int width, int height) {
        return createContentImage(content, width, height, Color.WHITE, Color.BLACK);
    }


    /**
     * 生成基于content内容的图片
     *
     * @param content   图片内容
     * @param width     图片宽
     * @param height    图片高
     * @param bgColor   图片背景色 空则白色
     * @param fontColor 文字颜色色 空则黑色
     * @return BufferedImage
     */
    public static BufferedImage createContentImage(String content, int width, int height, Color bgColor, Color fontColor) {
        return createContentImage(content, width, height, ObjectUtil.defaultIfNull(bgColor, Color.WHITE),
                ObjectUtil.defaultIfNull(fontColor, Color.BLACK), false);
    }


    /**
     * 生成基于content内容的图片
     *
     * @param content                   图片内容
     * @param width                     图片宽
     * @param height                    图片高
     * @param backgroundTransparentFlag 背景是否透明
     * @return Image
     */
    public static Image createContentImage(String content, int width, int height, boolean backgroundTransparentFlag) {
        return createContentImage(content, width, height, Color.WHITE, Color.BLACK, backgroundTransparentFlag);
    }

    /**
     * 生成基于content内容的图片
     *
     * @param content                   图片内容
     * @param width                     图片宽
     * @param height                    图片高
     * @param bgColor                   图片背景色 空则白色
     * @param fontColor                 文字颜色色 空则黑色
     * @param backgroundTransparentFlag 背景是否需要透明 true透明且bgColor不生效
     * @return BufferedImage
     */
    public static BufferedImage createContentImage(String content, int width, int height, Color bgColor, Color fontColor, boolean backgroundTransparentFlag) {
        // 图片设置：宽、高、背景透明
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);// 获取Image对象
        Graphics2D g2d = image.createGraphics();

        // 填充白色背景图
        g2d.setColor(ObjectUtil.defaultIfNull(bgColor, Color.WHITE));
        g2d.fillRect(0, 0, width, height);

        // 背景透明
        if (backgroundTransparentFlag) {
            image = g2d.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
        }

        int fontSize = 25;

        // g2d.dispose();
        g2d = image.createGraphics();
        // 设置字体颜色和透明度
        g2d.setColor(ObjectUtil.defaultIfNull(fontColor, Color.BLACK));
        g2d.setStroke(new BasicStroke(1));
        // 设置字体
        Font font = new Font("微软雅黑", Font.BOLD, fontSize);
        g2d.setFont(font);

        FontRenderContext context = g2d.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(content, context);


        // 文字垂直居中显示
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = -bounds.getY();
        double baseY = y + ascent;
        g2d.drawString(content, (int) x, (int) baseY);

        // 设置透明度
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
        // 释放对象
        g2d.dispose();
        return image;
    }


    /**
     * 垂直合并图片
     * 代码复制粘贴自{<a href="https://www.cnblogs.com/chbyiming-bky/articles/8940105.html">...</a>}
     *
     * @param imgs 图片
     */
    public static BufferedImage mergeImage(BufferedImage... imgs) {
        if (imgs == null) {
            return null;
        }
        imgs = ArrayUtil.removeNull(imgs);
        if (ArrayUtil.isNotEmpty(imgs)) {
            return mergeImage(false, imgs);
        }
        return null;
    }

    /**
     * 合并任数量的图片成一张图片
     * 代码复制粘贴自{<a href="https://www.cnblogs.com/chbyiming-bky/articles/8940105.html">...</a>}
     *
     * @param isHorizontal true代表水平合并，fasle代表垂直合并
     * @param imgs         待合并的图片数组
     */
    public static BufferedImage mergeImage(boolean isHorizontal, BufferedImage... imgs) {

        java.util.List<BufferedImage> bufferedImageList = Arrays.stream(imgs)
                .filter(ObjectUtil::isNotNull)
                .collect(Collectors.toList());
        imgs = Convert.convert(BufferedImage[].class, bufferedImageList, new BufferedImage[0]);

        // 生成新图片
        BufferedImage destImage = null;
        // 计算新图片的长和高
        int all = 0, alls = 0, allowMax = 0, allhMax = 0;
        // 获取总长、总宽、最长、最宽
        for (BufferedImage img : imgs) {
            if (img == null) {
                continue;
            }
            all += img.getWidth();
            alls += img.getHeight();
            if (img.getWidth() > allowMax) {
                allowMax = img.getWidth();
            }
            if (img.getHeight() > allhMax) {
                allhMax = img.getHeight();
            }
        }
        // 创建新图片
        if (isHorizontal) {
            destImage = new BufferedImage(all, allhMax, BufferedImage.TYPE_INT_RGB);
        } else {
            destImage = new BufferedImage(allowMax, alls, BufferedImage.TYPE_INT_RGB);
        }
        // 合并所有子图片到新图片
        int wx = 0, wy = 0;
        for (BufferedImage img : imgs) {
            int w1 = img.getWidth();
            int h1 = img.getHeight();
            // 从图片中读取RGB
            int[] ImageArrayOne = new int[w1 * h1];
            // 逐行扫描图像中各个像素的RGB到数组中
            ImageArrayOne = img.getRGB(0, 0, w1, h1, ImageArrayOne, 0, w1);
            if (isHorizontal) { // 水平方向合并
                // 设置上半部分或左半部分的RGB
                destImage.setRGB(wx, 0, w1, h1, ImageArrayOne, 0, w1);
            } else { // 垂直方向合并
                // 设置上半部分或左半部分的RGB
                destImage.setRGB(0, wy, w1, h1, ImageArrayOne, 0, w1);
            }
            wx += w1;
            wy += h1;
        }
        return destImage;
    }


    /**
     * 将img1图片放置在img2的水平垂直居中位置
     *
     * @param img1 File
     * @param img2 File
     * @return Image
     */
    public static Image imageToImageCenter(File img1, File img2) throws IOException {
        return imageToImageLocation(img1, img2, true, true);
    }

    /**
     * 将img1图片放置在img2的水平垂直居中位置
     *
     * @param img1 BufferedImage
     * @param img2 BufferedImage
     * @return BufferedImage
     */
    public static BufferedImage imageToImageCenter(BufferedImage img1, BufferedImage img2) throws IOException {
        return imageToImageLocation(img1, img2, true, true);
    }

    /**
     * 将img1图片放置在img2的位置
     *
     * @param horizontalCenterFlag true：img1在img2水平居中
     * @param verticalCenterFlag   true：img1在img2垂直居中
     * @return Image
     */
    public static Image imageToImageLocation(File img1, File img2, boolean horizontalCenterFlag, boolean verticalCenterFlag) throws IOException {
        return imageToImageLocation(ImgUtil.read(img1), ImgUtil.read(img2), horizontalCenterFlag, verticalCenterFlag);
    }

    /**
     * 将img1图片放置在img2的位置
     *
     * @param horizontalCenterFlag true：img1在img2水平居中
     * @param verticalCenterFlag   true：img1在img2垂直居中
     * @return BufferedImage
     */
    public static BufferedImage imageToImageLocation(BufferedImage img1, BufferedImage img2, boolean horizontalCenterFlag, boolean verticalCenterFlag) throws IOException {
        if (ObjectUtil.hasEmpty(img1, img2)) {
            return img2;
        }
        int width1 = img1.getWidth();
        int height1 = img1.getHeight();
        int width2 = img2.getWidth();
        int height2 = img2.getHeight();

        if (horizontalCenterFlag && img1.getWidth() > width2) {
            return img2;
        }
        if (verticalCenterFlag && img1.getHeight() > height2) {
            return img2;
        }

        int startX = 0;
        if (horizontalCenterFlag) {
            startX = (width2 - width1) / 2;
        }
        int startY = 0;
        if (verticalCenterFlag) {
            startY = (height2 - height1) / 2;
        }

        // Image destImage = new Image(width2, height2, Image.TYPE_INT_RGB);
        // 从图片中读取RGB
        int[] ImageArrayOne = new int[width1 * height1];

        BufferedImage destImage = ImgUtil.copyImage(img2, img2.getType());
        ImageArrayOne = img1.getRGB(0, 0, width1, height1, ImageArrayOne, 0, width1);
        // 设置上半部分或左半部分的RGB
        destImage.setRGB(startX, startY, width1, height1, ImageArrayOne, 0, width1);

        return destImage;
    }

    /**
     * 原图压缩
     *
     * @param sourceImage  原图
     * @param imageQuality 压缩质量 0~1之前
     * @return byte
     */
    @SneakyThrows
    public static byte[] compress(File sourceImage, Number imageQuality) {
        imageQuality = ObjectUtil.defaultIfNull(imageQuality, 1);
        Assert.checkBetween(imageQuality, 0, 1);

        if (FileUtil.isFile(sourceImage)) {
            if (NumberUtil.equals(Convert.toDouble(imageQuality), Convert.toDouble(1))) {
                return FileUtil.readBytes(sourceImage);
            } else {
                ByteArrayOutputStream compressJpgOutputStream = null;
                try {

                    BufferedImage bufferedImage = null;
                    //转成jpg格式图片
                    if (StrUtil.equalsAnyIgnoreCase(FileUtil.extName(sourceImage), IMAGE_TYPE_JPG, IMAGE_TYPE_JPEG)) {
                        bufferedImage = toBufferedImage(toImage(FileUtil.readBytes(sourceImage)));
                    } else {
                        ByteArrayOutputStream jpgOutputStream = new ByteArrayOutputStream();
                        EnhanceImgUtils.convert(IoUtil.toStream(sourceImage), ImgUtil.IMAGE_TYPE_JPG, jpgOutputStream);
                        bufferedImage = EnhanceImgUtils.toImage(jpgOutputStream.toByteArray());
                    }

                    // 开始压缩
                    compressJpgOutputStream = new ByteArrayOutputStream();
                    // Thumbnails.of(bufferedImage)
                    //         .scale(1f)
                    //         .outputQuality(Convert.toFloat(imageQuality))
                    //         .outputFormat(IMAGE_TYPE_JPG)
                    //         .toOutputStream(compressJpgOutputStream);

                    return compressJpgOutputStream.toByteArray();
                } catch (Exception e) {
                    log.error("图片格式压缩出错：{} \n异常：{}", FileUtil.getAbsolutePath(sourceImage), ExceptionUtil.stacktraceToOneLineString(e));
                    return FileUtil.readBytes(sourceImage);
                } finally {
                    IoUtil.close(compressJpgOutputStream);
                }

            }
        } else {
            return null;
        }
    }

    /**
     * 将原图压缩并保存到新的目标文件中
     *
     * @param sourceImage           原图
     * @param imageQuality          压缩质量 0~1之前
     * @param jpgCompressResultFile 压缩后的图片路径
     * @return Image
     */
    public static Image compressToTargetFile(File sourceImage, Number imageQuality, File jpgCompressResultFile) {
        if (jpgCompressResultFile == null) {
            return null;
        }

        return Optional.ofNullable(compress(sourceImage, imageQuality))
                .map(compressImage -> {
                    String resultFileExName = FileUtil.extName(jpgCompressResultFile);
                    if (StrUtil.equalsAnyIgnoreCase(resultFileExName, IMAGE_TYPE_JPG) || StrUtil.isBlank(resultFileExName)) {

                        FileUtil.writeBytes(compressImage, jpgCompressResultFile);
                        return toImage(compressImage);
                    } else {
                        ByteArrayOutputStream resultByteArrayOutputStream = null;
                        ByteArrayInputStream compressImageByteArrayInputStream = null;
                        try {
                            resultByteArrayOutputStream = new ByteArrayOutputStream();
                            compressImageByteArrayInputStream = IoUtil.toStream(compressImage);
                            convert(compressImageByteArrayInputStream, resultFileExName, resultByteArrayOutputStream);
                            FileUtil.writeBytes(resultByteArrayOutputStream.toByteArray(), jpgCompressResultFile);
                            return toImage(resultByteArrayOutputStream.toByteArray());
                        } catch (Exception e) {
                            log.error("图片格式转换{}=>{}异常：{}", ImgUtil.IMAGE_TYPE_JPG, resultFileExName, ExceptionUtil.stacktraceToOneLineString(e));
                            FileUtil.writeBytes(compressImage, jpgCompressResultFile);
                            return toImage(FileUtil.readBytes(sourceImage));
                        } finally {
                            IoUtil.close(compressImageByteArrayInputStream);
                            IoUtil.close(resultByteArrayOutputStream);
                        }
                    }
                })
                .orElse(null);
    }


    /**
     * 裁剪（缩放应用于rectangle里面的x、y、width、height进行缩放）
     *
     * @param srcImage  原图
     * @param rectangle 裁剪后的图片（里面的参与需要基于scalingX、scalingY进行缩放）
     * @param scalingX  对于X轴方向进行缩放
     * @param scalingY  对于Y轴方向进行缩放
     * @return Image
     */
    public static Image cut(Image srcImage, Rectangle rectangle, Number scalingX, Number scalingY) {
        Integer scalingXpoint = Convert.toInt(rectangle.getX());
        Integer scalingRwidth = Convert.toInt(rectangle.getWidth());
        if (scalingX != null) {
            scalingXpoint = Convert.toInt(rectangle.getX() * Convert.toDouble(scalingX));
            scalingRwidth = Convert.toInt(rectangle.getWidth() * Convert.toDouble(scalingX));
        }
        Integer scalingYpoint = Convert.toInt(rectangle.getY());
        Integer scalingRHeight = Convert.toInt(rectangle.getHeight());
        if (scalingY != null) {
            scalingYpoint = Convert.toInt(rectangle.getY() * Convert.toDouble(scalingY));
            scalingRHeight = Convert.toInt(rectangle.getHeight() * Convert.toDouble(scalingY));
        }
        rectangle = new Rectangle(scalingXpoint, scalingYpoint, scalingRwidth, scalingRHeight);

        return Img.from(srcImage).setPositionBaseCentre(false).cut(rectangle).getImg();
    }

    /**
     * 描边，此方法为向内描边，会覆盖图片相应的位置
     *
     * @param dirFile 图片目录
     */
    public static void strokeByDir(File dirFile) {
        Optional.ofNullable(dirFile)
                .ifPresent(dir -> {
                    Object[] fieldsValue = ReflectUtil.getFieldsValue(ImgUtil.class);
                    String[] fieldStrsValue = Convert.convert(new TypeReference<String[]>() {
                    }, fieldsValue);

                    List<File> imageFiles = FileUtil.loopFiles(dir, elemFile -> StrUtil.containsAnyIgnoreCase(FileUtil.extName(elemFile), fieldStrsValue));

                    imageFiles.stream().parallel().forEach(imageFile -> {
                        Img sourceImg = new Img(ImgUtil.read(imageFile));
                        String parentPath = FileUtil.getParent(imageFile.getAbsolutePath(), 1);
                        String mainName = FileUtil.mainName(imageFile);
                        String extName = FileUtil.extName(imageFile);
                        File strokeImageFile = new File(StrUtil.format("{}\\\\{}_stroke.{}", parentPath, mainName, extName));
                        Img strokeImg = sourceImg.stroke(Color.black, 5);
                        strokeImg.write(strokeImageFile);
                    });

                });
    }
}
