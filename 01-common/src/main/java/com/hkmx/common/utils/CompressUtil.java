package com.hkmx.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author maoxwa
 * @version 1.0
 * @date 2021/3/31 23:44
 */
public class CompressUtil {
    public static void main(String[] args) throws IOException {
        // 原文件
        // String inFileName = "D:\\data\\app\\logs\\gc-server\\gc-service.log";
        // compressFile(inFileName);

        // 压缩文件
        String gzFileName = "D:\\data\\app\\logs\\gc-server\\gc-service.log.gz";
        decompressFile(gzFileName);
    }

    // 压缩
    public static void compressFile(String srcFile) throws IOException {
        String desFile = srcFile + ".gz";
        byte[] buffer = new byte[10240];
        int len;
        try (FileInputStream fis = new FileInputStream(new File(srcFile));
             GZIPOutputStream gzos = new GZIPOutputStream(new FileOutputStream(desFile))) {
            while ((len = fis.read(buffer)) > 0) {
                gzos.write(buffer);
            }
            gzos.flush();
        } catch (IOException e) {
            throw new RuntimeException("压缩失败：" + srcFile);
        }

    }

    // 解压
    public static void decompressFile(String srcFile) {
        if (!getExtName(srcFile).equalsIgnoreCase("gz")) {
            throw new RuntimeException("文件名必须是gz后缀");
        }
        String descFile = getFileName(srcFile);

        try (GZIPInputStream gzis = new GZIPInputStream(new FileInputStream(srcFile));
             FileOutputStream fos = new FileOutputStream(descFile);) {
            byte[] buf = new byte[1024];
            int len;
            while ((len = gzis.read(buf)) > 0) {
                fos.write(buf, 0, len);
            }
            fos.flush();
        } catch (IOException e) {
            throw new RuntimeException("解压文件失败");
        }
    }

    // 获取文件后缀名
    public static String getExtName(String f) {
        String ext = "";
        int i = f.lastIndexOf('.');
        if (i > 0 && i < f.length() - 1) {
            ext = f.substring(i + 1);
        }
        return ext;
    }

    // 获取文件名
    public static String getFileName(String zipFileName) {
        String fileName = "";
        int i = zipFileName.lastIndexOf('.');

        if (i > 0 && i < zipFileName.length() - 1) {
            fileName = zipFileName.substring(0, i);
        }
        return fileName;
    }
}
