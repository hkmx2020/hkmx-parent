package com.hkmx.common.imagemerge;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author maoxingwen
 * @date 2023/2/28 17:35
 * @description
 */
@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Element {

    /**
     * x 坐标
     */
    private BigDecimal x = new BigDecimal(0);

    /**
     * y 坐标
     */
    private BigDecimal y = new BigDecimal(0);

    /**
     * 宽度
     */
    private BigDecimal width = new BigDecimal(0);

    /**
     * 高度
     */
    private BigDecimal height = new BigDecimal(0);

    /**
     * x坐标缩放倍数
     */
    private BigDecimal scaleX = new BigDecimal(1);

    /**
     * y坐标缩放倍数
     */
    private BigDecimal scaleY = new BigDecimal(1);

    private String name;

    private String img;

    private Boolean background = false;

    /**
     * 背景色
     */
    private String backgroundColor;

    /**
     * 类型
     */
    private String type;

    /**
     * 输入源形状
     */
    private String shapeType;

    /**
     * 透明度
     */
    private BigDecimal alpha = new BigDecimal(1);

    private String id;

    /**
     * 元素类型. 2:图片 4: 输入源 6: 纯文字
     */
    private Integer clientResourceClassify;

    /**
     * 元素内容
     */
    private String content;

    /**
     * 字体类型
     */
    private String fontType;

    /**
     * 字体颜色
     */
    private String fontColor;

    /**
     * 字体大小
     */
    private Integer fontSize;

    /**
     * 示例值: img
     */
    private String domType;

    /**
     * 是否是共享视频
     */
    private Boolean shapeVideo = false;

    /**
     * 子元素
     */
    private List<Element> children = new ArrayList<>(2);

}
