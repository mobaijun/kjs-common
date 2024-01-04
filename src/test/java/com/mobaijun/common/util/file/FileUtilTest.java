package com.mobaijun.common.util.file;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Description: [FileUtilTest测试类]
 * Author: [xzh]
 * Date: [2023/12/22 11:44]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2021.1.4]
 */
public class FileUtilTest {

    @Test
    public void testWriteBytes() throws Exception {
        OutputStream outPutStream = new FileOutputStream("3.jpg");
        FileUtil.writeBytes(FileUtil.getFileAbsolutePath("1.jpg"), outPutStream);
    }

    @Test
    public void testDeleteFile() throws Exception {
        boolean result = FileUtil.deleteFile(FileUtil.getFileAbsolutePath("2.jpg"));
        Assert.assertEquals(true, result);
    }

    @Test
    public void testIsValidFilename() throws Exception {
        boolean result = FileUtil.isValidFilename("2.jpg");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testCopyFile() throws Exception {
        boolean result = FileUtil.copyFile(new File(FileUtil.getFileAbsolutePath("2.jpg")), new File(FileUtil.getFileAbsolutePath("2.jpg")));
        Assert.assertEquals(true, result);
    }

    @Test
    public void testGetSystemTempDir() throws Exception {
        File result = FileUtil.getSystemTempDir();
        Assert.assertNotNull(result);
    }

    @Test
    public void testUpdateTmpDir() throws Exception {
        FileUtil.updateTmpDir("Temp1");
    }

    @Test
    public void testGetTemplateFile() throws Exception {
        File result = FileUtil.getTemplateFile("test-template");
        Assert.assertNotNull(result);
    }

    @Test
    public void testGetInputStreamByUrlPath() throws Exception {
        InputStream result = FileUtil.getInputStreamByUrlPath("https://img2.baidu.com/it/u=1103740651,3828883478&fm=253&fmt=auto&app=120&f=JPEG?w=1280&h=800");
        Assert.assertNotNull(result);
    }

    @Test
    public void testReadTemplate() throws Exception {
        String result = FileUtil.readTemplate("1.jpg");
        Assert.assertNotNull(result);
    }

    @Test
    public void testGetAllFilesInDirectory() throws Exception {
        List<File> result = FileUtil.getAllFilesInDirectory(this.getClass().getClassLoader().getResource("").getPath());
        Assert.assertNotNull(result);
    }

    @Test
    public void testReadLines() throws Exception {
        List<String> result = FileUtil.readLines(new File(FileUtil.getFileAbsolutePath("demo.txt")), StandardCharsets.UTF_8);
        Assert.assertNotNull(result);
    }

    @Test
    public void testWriteUtf8Lines() throws Exception {
        ArrayList<File> allFilesInDirectory = (ArrayList<File>) FileUtil.getAllFilesInDirectory(this.getClass().getClassLoader().getResource("").getPath());
        FileUtil.writeUtf8Lines(allFilesInDirectory, new File(FileUtil.getFileAbsolutePath("demo.txt")));
    }

    @Test
    public void testAppendToFile() throws Exception {
        Collection<File> allFilesInDirectory = (Collection<File>) FileUtil.getAllFilesInDirectory(this.getClass().getClassLoader().getResource("").getPath());
        boolean result = FileUtil.appendToFile(allFilesInDirectory, "demo03", true);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testGetFilePrefix() throws Exception {
        String result = FileUtil.getFilePrefix("demo.txt");
        Assert.assertEquals("demo", result);
    }
}

