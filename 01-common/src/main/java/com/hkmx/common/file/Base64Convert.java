package com.hkmx.common.file;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Base64Convert {

    BASE64Decoder decoder = new BASE64Decoder();

    public static String ioToBase64() throws IOException {
        String fileName = "D:\\data\\公众号照片.jpg"; //源文件
        String strBase64 = null;
        try {
            InputStream in = new FileInputStream(fileName);
            // in.available()返回文件的字节长度
            byte[] bytes = new byte[in.available()];
            // 将文件中的内容读入到数组中
            in.read(bytes);
            strBase64 = new BASE64Encoder().encode(bytes);
            // 将字节流数组转换为字符串
            in.close();
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return strBase64;
    }

    public static void main(String[] args) throws IOException {
        // String s = ioToBase64();
        // System.out.println(s);
        //
        // String name = "{\"rc_url\":{\"path\":\"/v3/BIDNJTVC81M225MK/base64.jpeg\",\"type\":0}}";
        //
        // JsonObject jsonElement = GsonUtil.fromJson(name, JsonObject.class);
        // System.out.println(jsonElement.toString());

        // System.out.println(System.currentTimeMillis());

        String vidibilityRange = "[{\"type\":1},{\"type\":2},{\"type\":3,\"userUid\":\"HLyk9fzMTUgoP6e4TAuNfc\"}]";

        String name = "[\"S0sYrK17TWYhWNbY7mbCxw\"]";

        // JsonArray array = GsonUtil.fromJson(name, JsonArray.class);
        // ArrayList arrayList = new Gson().fromJson(array, ArrayList.class);
        // System.out.println(GsonUtil.toJson(arrayList));


    }
}
