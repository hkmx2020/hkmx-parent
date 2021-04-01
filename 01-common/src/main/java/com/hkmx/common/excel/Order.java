package com.hkmx.common.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Data
public class Order {

    @ExcelProperty({"主标题", "订单ID"})
    private Integer id;

    /**
     * 订单描述
     */
    @ColumnWidth(100)
    @ExcelProperty({"主标题","订单描述"})
    private String description;

    public static void main(String[] args) {
        Map map = new HashMap();
        boolean type = Optional.of(map).map(v -> v.get("type")).orElse(false).equals("2");
        System.out.println(type);
    }

}
