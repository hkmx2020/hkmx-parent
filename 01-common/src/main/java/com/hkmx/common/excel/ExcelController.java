package com.hkmx.common.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.ExtendedColor;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequestMapping("/excel")
@RestController
public class ExcelController {

    @GetMapping("/export")
    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试导出", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Order.class).sheet("模板").doWrite(data());
    }


    private static List<Order> data() {
        List<Order> list = new ArrayList<Order>();
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setId(i);
            order.setDescription("描述" + i);
            // list.add(order);
        }
        return list;
    }

    public static void main(String[] args) {
        // 写法1
        String fileName = "/data/excel/导出订单.xlsx";

        // EasyExcel.write(fileName, Order.class).sheet("订单").doWrite(data());

        // 这里 需要指定写用哪个class去写
        ExcelWriter excelWriter = EasyExcel.write(fileName, Order.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
        excelWriter.write(data(), writeSheet);
        // 千万别忘记 finish 会帮忙关闭流
        excelWriter.finish();

        CreationHelper createHelper = new WriteSheetHolder(null, null).getSheet().getWorkbook().getCreationHelper();
        ExtendedColor extendedColor = createHelper.createExtendedColor();
        byte[] argb = extendedColor.getARGB();
        extendedColor.setRGB(new byte[]{0, 1, 2});
        Cell cell = new SXSSFCell(null, null);
        CellStyle cellStyle = cell.getCellStyle();

    }

}
