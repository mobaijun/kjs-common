package com.mobaijun.common.util.image;

import com.mobaijun.common.util.constant.Constant;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: ImageUtils
 * class description： 图片处理工具类
 *
 * @author MoBaiJun 2022/5/27 13:49
 */
public class ImageUtils {

    /**
     * 把图片转换成string类型
     *
     * @param imagePath 图片地址
     * @return String
     */
    public static String imgToBase64String(String imagePath) {
        try {
            BufferedImage imageBuffer = ImageIO.read(new File(imagePath));
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(imageBuffer, Constant.JPG, Base64.getEncoder().wrap(os));
            return os.toString(StandardCharsets.ISO_8859_1.name());
        } catch (final IOException ioe) {
            throw new UncheckedIOException(ioe);
        }
    }

    /**
     * 把string类型转换成图片
     *
     * @param base64String base64String
     * @return BufferedImage
     */
    public static BufferedImage base64StringToImg(String base64String) {
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes = decoder.decodeBuffer(base64String);
            ByteArrayInputStream bass = new ByteArrayInputStream(bytes);
            return ImageIO.read(bass);
        } catch (final IOException ioe) {
            throw new UncheckedIOException(ioe);
        }
    }

    /**
     * 绘制图片
     *
     * @param imageBuffer imageBuffer
     */
    public static void drawImage(BufferedImage imageBuffer) {
        ImageIcon icon = new ImageIcon(imageBuffer);
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(imageBuffer.getWidth(), imageBuffer.getHeight());
        JLabel lbl = new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
