package com.hkmx.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonUtil {

    private static Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static String toJson(Object obj, Type type) {
        return gson.toJson(obj, type);
    }

    public static <T> T fromJson(String str, Class<T> clazz) {
        return gson.fromJson(str, clazz);
    }

    public static Object fromJson(Reader reader, Type type) {
        return gson.fromJson(reader, type);
    }


    public static <T> T fromJson(JsonElement json, Class<T> classOfT) {
        T t = gson.fromJson(json, classOfT);
        return t;
    }

    public static <T> List<T> fromJsonToList(String str, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        JsonArray array = new JsonParser().parse(str).getAsJsonArray();
        for (JsonElement obj : array) {
            list.add(gson.fromJson(obj, clazz));
        }
        return list;
    }

    public static void main(String[] args) {
        String content1 = "https://wm-boss-ui-dev.wm-motor.com/ui-security/pkiInfo/queryPkiInfoBySn?pageSize=20&pageNum=1&sn=&type=hu&_=1613721086683";
        String content2 = "https://wm-boss-ui-fat.wm-motor.com/ui-security/pkiInfo/queryPkiInfoBySn?pageSize=20&pageNum=1&sn=&type=hu&_=1613721101684";
    }


}
