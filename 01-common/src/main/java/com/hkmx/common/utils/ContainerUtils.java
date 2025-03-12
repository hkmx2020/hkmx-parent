package com.hkmx.common.utils;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 * 容器操作工具类
 */
public class ContainerUtils {

    private ContainerUtils() {
    }

    /**
     * 源数据
     */
    public static final String SOURCE_KEY = "sourceKey";
    /**
     * 目标数据
     */
    public static final String TARGET_KEY = "targetKey";

    /**
     * 数组是否为空
     *
     * @param elements
     * @param <E>
     * @return
     */
    public static <E> boolean isEmpty(E[] elements) {
        return Objects.isNull(elements) || (elements.length == 0);
    }

    /**
     * map数据根据key求差集
     *
     * @param source
     * @param target
     * @param <V>
     * @return
     */
    public static <K, V> Collection<V> differ(Map<K, V> source, Map<K, V> target) {
        if (CollectionUtils.isEmpty(source)) {
            return Collections.emptyList();
        }
        if (CollectionUtils.isEmpty(target)) {
            return source.values();
        }
        List<V> differenceList = new ArrayList<>();
        source.keySet().stream().forEach(key -> {
            if (!target.containsKey(key)) {
                differenceList.add(source.get(key));
            }
        });
        return differenceList;
    }

    /**
     * map数据根据key求交集
     *
     * @param source
     * @param target
     * @param <V>
     * @return
     */
    public static <K, V> Collection<V> same(Map<K, V> source, Map<K, V> target) {
        if (CollectionUtils.isEmpty(source) || CollectionUtils.isEmpty(target)) {
            return Collections.emptyList();
        }
        List<V> sameList = new ArrayList<>();
        source.keySet().stream().forEach(key -> {
            if (target.containsKey(key)) {
                sameList.add(source.get(key));
            }
        });
        return sameList;
    }

    /**
     * collection数据求差集
     *
     * @param source
     * @param target
     * @param <V>
     * @return
     */
    public static <V> Collection<V> differ(Collection<V> source, Collection<V> target) {
        if (CollectionUtils.isEmpty(source)) {
            return Collections.emptyList();
        }
        if (CollectionUtils.isEmpty(target)) {
            return source;
        }
        Collection<V> differenceList = new ArrayList<>();
        source.stream().forEach(entity -> {
            if (!target.contains(entity)) {
                differenceList.add(entity);
            }
        });
        return differenceList;
    }

}
