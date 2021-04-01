package com.hkmx.common.utils;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author maoxwa
 * @version 1.0
 * @date 2021/3/31 23:15
 */
public class GzipUtil {

    private static FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "GZIP压缩文件(*.gz)", "gz");

    public static void doCompress(File file, String destpath) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);

        File gf = new File(destpath);
        FileOutputStream fos = new FileOutputStream(gf);
        GZIPOutputStream gzos = new GZIPOutputStream(fos);
        BufferedOutputStream bos = new BufferedOutputStream(gzos);
        readAndWrite(bis, bos);
    }

    public static void doUnCompress(File srcFile, String destpath) throws IOException {
        FileInputStream fis = new FileInputStream(srcFile);
        GZIPInputStream gzis = new GZIPInputStream(fis);
        BufferedInputStream bis = new BufferedInputStream(gzis);

        File tf = new File(destpath);
        FileOutputStream fos = new FileOutputStream(tf);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        readAndWrite(bis, bos);

    }

    public final FileNameExtensionFilter getFileFilter() {
        return filter;
    }

    /**
     * 从bis读取数据并写入bos中
     * @param bis
     * @param bos
     * @throws IOException
     */
    public static void readAndWrite(BufferedInputStream bis, BufferedOutputStream bos) throws IOException {
        byte[] buf = new byte[1024];
        int len;
        while((len = bis.read(buf)) > 0) {
            bos.write(buf, 0, len);
        }
        bos.flush();
        bos.close();
        bis.close();
    }

    public static void main(String[] args) throws IOException {
        File srcFile = new File("D:\\data\\app\\logs\\gc-server\\gc-service.log");
        // String targetPath = "D:\\data\\gc-service.log.gz";
        // doCompress(srcFile, targetPath);
        String targetPath = "D:\\data\\gc-service.gz";
        doUnCompress(new File(targetPath), "D:\\data\\gc-service.log");
    }

}
