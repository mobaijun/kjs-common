package com.mobaijun.common.enums.http;

import com.mobaijun.common.util.StringUtils;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: ContentType
 * enum description：内容类型
 * <a href="https://www.runoob.com/http/http-content-type.html">内容类型</a>
 *
 * @author MoBaiJun 2022/10/26 17:14
 */
@Getter
public enum ContentTypeEnum {

    /**
     * AAC音频
     */
    AAC("acc", "AAC音频", "audio/aac"),

    /**
     * AbiWord文件
     */
    ABW("abw", "AbiWord文件", "application/x-abiword"),

    /**
     * 存档文件
     */
    ARC("arc", "存档文件", "application/x-freearc"),

    /**
     * 音频视频交错格式
     */
    AVI("avi", "音频视频交错格式", "video/x-msvideo"),

    /**
     * 亚马逊Kindle电子书格式
     */
    AZW("azw", "亚马逊Kindle电子书格式", "application/vnd.amazon.ebook"),

    /**
     * 任何类型的二进制数据
     */
    BIN("bin", "任何类型的二进制数据", "application/octet-stream"),

    /**
     * Windows OS / 2位图图形
     */
    BMP("bmp", "Windows OS / 2位图图形", "image/bmp"),

    /**
     * BZip存档
     */
    BZ("bz", "BZip存档", "application/x-bzip"),

    /**
     * BZip2存档
     */
    BZ2("bz2", "BZip2存档", "application/x-bzip2"),

    /**
     * C-Shell脚本
     */
    CSH("csh", "C-Shell脚本", "application/x-csh"),

    /**
     * 级联样式表（CSS）
     */
    CSS("css", "级联样式表（CSS）", "text/css"),

    /**
     * 逗号分隔值（CSV）
     */
    CSV("csv", "逗号分隔值（CSV）", "text/csv"),

    /**
     * 微软Word文件
     */
    DOC("doc", "微软Word文件", "application/msword"),

    /**
     * Microsoft Word（OpenXML）
     */
    DOCX("docx", "Microsoft Word（OpenXML）", "application/vnd.openxmlformats-officedocument.wordprocessingml.document"),

    /**
     * MS Embedded OpenType字体
     */
    EOT("eot", "MS Embedded OpenType字体", "application/vnd.ms-fontobject"),

    /**
     * 电子出版物（EPUB）
     */
    EPUB("epub", "电子出版物（EPUB）", "application/epub+zip"),

    /**
     * GZip压缩档案
     */
    GZ("gz", "GZip压缩档案", "application/gzip"),

    /**
     * 图形交换格式（GIF）
     */
    GIF("gif", "图形交换格式（GIF）", "image/gif"),

    /**
     * 超文本标记语言（HTML）
     */
    HTM("htm", "超文本标记语言（HTML）", "text/html"),

    /**
     * 超文本标记语言（HTML）
     */
    HTML("html", "超文本标记语言（HTML）", "text/html"),

    /**
     * 图标格式
     */
    ICO("ico", "图标格式", "image/vnd.microsoft.icon"),

    /**
     * iCalendar格式
     */
    ICS("ics", "iCalendar格式", "text/calendar"),

    /**
     * Java存档
     */
    JAR("jar", "Java存档", "application/java-archive"),

    /**
     * JPEG图像
     */
    JPEG("jpeg", "JPEG图像", "image/jpeg"),

    /**
     * JPEG图像
     */
    JPG("jpg", "JPEG图像", "image/jpeg"),

    /**
     * JavaScript
     */
    JS("js", "JavaScript", "text/javascript"),

    /**
     * JSON格式
     */
    JSON("json", "JSON格式", "application/json"),

    /**
     * JSON-LD格式
     */
    JSONLD("jsonld", "JSON-LD格式", "application/ld+json"),

    /**
     * 乐器数字接口（MIDI）
     */
    MID("mid", "乐器数字接口（MIDI）", "audio/midi"),

    /**
     * 乐器数字接口（MIDI）
     */
    MIDI("midi", "乐器数字接口（MIDI）", "audio/midi"),

    /**
     * JavaScript模块
     */
    MJS("mjs", "JavaScript模块", "text/javascript"),

    /**
     * MP3音频
     */
    MP3("mp3", "MP3音频", "audio/mpeg"),

    /**
     * MPEG视频
     */
    MPEG("mpeg", "MPEG视频", "video/mpeg"),

    /**
     * 苹果安装程序包
     */
    MPKG("mpkg", "苹果安装程序包", "application/vnd.apple.installer+xml"),

    /**
     * OpenDocument演示文稿文档
     */
    ODP("odp", "OpenDocument演示文稿文档", "application/vnd.oasis.opendocument.presentation"),

    /**
     * OpenDocument电子表格文档
     */
    ODS("ods", "OpenDocument电子表格文档", "application/vnd.oasis.opendocument.spreadsheet"),

    /**
     * OpenDocument文字文件
     */
    ODT("odt", "OpenDocument文字文件", "application/vnd.oasis.opendocument.text"),

    /**
     * OGG音讯
     */
    OGA("oga", "OGG音讯", "audio/ogg"),

    /**
     * OGG视频
     */
    OGV("ogv", "OGG视频", "video/ogg"),

    /**
     * OGG
     */
    OGX("ogx", "OGG", "application/ogg"),

    /**
     * OPUS音频
     */
    OPUS("opus", "OPUS音频", "audio/opus"),

    /**
     * otf字体
     */
    OTF("otf", "otf字体", "font/otf"),

    /**
     * 便携式网络图形
     */
    PNG("png", "便携式网络图形", "image/png"),

    /**
     * Adobe 可移植文档格式（PDF）
     */
    PDF("pdf", "Adobe 可移植文档格式（PDF）", "application/pdf"),

    /**
     * php
     */
    PHP("php", "php", "application/x-httpd-php"),

    /**
     * Microsoft PowerPoint
     */
    PPT("ppt", "Microsoft PowerPoint", "application/vnd.ms-powerpoint"),

    /**
     * Microsoft PowerPoint（OpenXML）
     */
    PPTX("pptx", "Microsoft PowerPoint（OpenXML）", "application/vnd.openxmlformats-officedocument.presentationml.presentation"),

    /**
     * RAR档案
     */
    RAR("rar", "RAR档案", "application/vnd.rar"),

    /**
     * 富文本格式
     */
    RTF("rtf", "富文本格式", "application/rtf"),

    /**
     * Bourne Shell脚本
     */
    SH("sh", "Bourne Shell脚本", "application/x-sh"),

    /**
     * 可缩放矢量图形（SVG）
     */
    SVG("svg", "可缩放矢量图形（SVG）", "image/svg+xml"),

    /**
     * 小型Web格式（SWF）或Adobe Flash文档
     */
    SWF("swf", "小型Web格式（SWF）或Adobe Flash文档", "application/x-shockwave-flash"),

    /**
     * 磁带存档（TAR）
     */
    TAR("tar", "磁带存档（TAR）", "application/x-tar"),

    /**
     * 标记图像文件格式（TIFF）
     */
    TIF("tif", "标记图像文件格式（TIFF）", "image/tiff"),

    /**
     * 标记图像文件格式（TIFF）
     */
    TIFF("tiff", "标记图像文件格式（TIFF）", "image/tiff"),

    /**
     * MPEG传输流
     */
    TS("ts", "MPEG传输流", "video/mp2t"),

    /**
     * ttf字体
     */
    TTF("ttf", "ttf字体", "font/ttf"),

    /**
     * 文本（通常为ASCII或ISO 8859- n
     */
    TXT("txt", "文本（通常为ASCII或ISO 8859- n", "text/plain"),

    /**
     * 微软Visio
     */
    VSD("vsd", "微软Visio", "application/vnd.visio"),

    /**
     * 波形音频格式
     */
    WAV("wav", "波形音频格式", "audio/wav"),

    /**
     * WEBM音频
     */
    WEBA("weba", "WEBM音频", "audio/webm"),

    /**
     * WEBM视频
     */
    WEBM("webm", "WEBM视频", "video/webm"),

    /**
     * WEBP图像
     */
    WEBP("webp", "WEBP图像", "image/webp"),

    /**
     * Web开放字体格式（WOFF）
     */
    WOFF("woff", "Web开放字体格式（WOFF）", "font/woff"),

    /**
     * Web开放字体格式（WOFF）
     */
    WOFF2("woff2", "Web开放字体格式（WOFF）", "font/woff2"),

    /**
     * XHTML
     */
    XHTML("xhtml", "XHTML", "application/xhtml+xml"),

    /**
     * 微软Excel
     */
    XLS("xls", "微软Excel", "application/vnd.ms-excel"),

    /**
     * 微软Excel（OpenXML）
     */
    XLSX("xlsx", "微软Excel（OpenXML）", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),

    /**
     * XML
     */
    XML("xml", "XML", "application/xml"),

    /**
     * XUL
     */
    XUL("xul", "XUL", "application/vnd.mozilla.xul+xml"),

    /**
     * ZIP
     */
    ZIP("zip", "ZIP", "application/zip"),

    /**
     * 3GPP audio/video container
     */
    MIME_3GP("3gp", "3GPP audio/video container", "video/3gpp"),

    /**
     * 3GPP audio/video container doesn't contain video
     */
    MIME_3GP_WITHOUT_VIDEO("3gp", "3GPP audio/video container doesn't contain video", "audio/3gpp2"),

    /**
     * 3GPP2 audio/video container
     */
    MIME_3G2("3g2", "3GPP2 audio/video container", "video/3gpp2"),

    /**
     * 3GPP2 audio/video container  doesn't contain video
     */
    MIME_3G2_WITHOUT_VIDEO("3g2", "3GPP2 audio/video container  doesn't contain video", "audio/3gpp2"),

    /**
     * 7-zip存档
     */
    MIME_7Z("7z", "7-zip存档", "application/x-7z-compressed");

    /**
     * 扩展
     */
    private final String extension;

    /**
     * 描述
     */
    private final String explain;

    /**
     * 类型
     */
    private final String type;

    ContentTypeEnum(String extension, String explain, String type) {
        this.extension = extension;
        this.explain = explain;
        this.type = type;
    }

    public static ContentTypeEnum findByExtension(String extension) {
        if (StringUtils.isEmpty(extension)) {
            return null;
        }
        for (ContentTypeEnum typesEnum : ContentTypeEnum.values()) {
            if (extension.equals(typesEnum.getExtension())) {
                return typesEnum;
            }
        }
        return null;
    }

    /**
     * 描述：Content-Type常用对照
     *
     * @param fileType 文件类型
     * @return 类型
     */
    public static String getContentType(String fileType) {
        ContentTypeEnum mimeTypeEnum = ContentTypeEnum.findByExtension(fileType);
        if (mimeTypeEnum != null) {
            return mimeTypeEnum.getType();
        }
        return "application/octet-stream";
    }
}
