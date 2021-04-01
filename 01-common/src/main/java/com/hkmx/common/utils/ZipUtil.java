package com.hkmx.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author maoxwa
 * @version 1.0
 * @date 2021/3/31 17:58
 */
public class ZipUtil {

    /**
     * 压缩文件目录分隔符。注意压缩时分割符不能使用 {@link File#separatorChar}
     */
    private static final String SEPERATOR = "/";

    /**
     * @param source 要压缩的文件或者目录
     * @param target 生成后的压缩文件
     * @throws Exception
     */
    public static void zip(String source, String target) {
        File file = new File(source);
        if (!file.exists()) {
            throw new RuntimeException("文件不存在");
        }
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(target));
             BufferedOutputStream bos = new BufferedOutputStream(zos);) {
            if (file.isFile()) {
                zipFile(zos, file, "", bos);
            } else {
                zipDirectory(zos, file, "", bos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void zipDirectory(ZipOutputStream zos, File file, String entryName, BufferedOutputStream bos) throws IOException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                zos.putNextEntry(new ZipEntry(entryName + SEPERATOR));
            }
            for (int i = 0; i < files.length; i++) {
                zipDirectory(zos, files[i], entryName + SEPERATOR + files[i].getName(), bos);
            }
            return;
        }
        zipFile(zos, file, entryName, bos);
    }

    private static void zipFile(ZipOutputStream zos, File file, String entryName, BufferedOutputStream bos) throws IOException {
        zos.putNextEntry(new ZipEntry(entryName));
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        int num;
        while ((num = bis.read()) != -1) {
            bos.write(num);
        }
        bis.close();
        fis.close();
    }

    /**
     * @param source 压缩文件路径
     * @param target 解压目标目录
     * @throws FileNotFoundException
     */
    public static void unzip(String source, String target) throws FileNotFoundException {
        File targetFile = new File(target);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        ZipInputStream zis = null;
        BufferedInputStream bis = null;
        try {
            zis = new ZipInputStream(new FileInputStream(source));
            bis = new BufferedInputStream(zis);
            File file;
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                file = new File(targetFile, entry.getName());
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                }
                if (entry.isDirectory()) {
                    file.mkdirs();
                    continue;
                }

                FileOutputStream fos = new FileOutputStream(file);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                int num;
                while ((num = bis.read()) != -1) {
                    bos.write(num);
                }
                bos.close();
                fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != bis) {
                    bis.close();
                }
                if (null != zis) {
                    zis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            zip("E:\\data1", "E:\\data2\\xw.zip");
            // unzip("E:\\data2\\xw.zip", "E:\\data2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
