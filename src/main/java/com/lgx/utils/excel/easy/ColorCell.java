package com.lgx.utils.excel.easy;

import com.alibaba.excel.EasyExcel;

import static com.lgx.utils.excel.easy.ExcelDate.getData;
import static com.lgx.utils.excel.easy.ExcelDate.getHead;

//根据表格内的内容赋予文字颜色
public class ColorCell {

    public static void main(String[] args) {
        testExport();
    }

    public static void testExport() {
        String fileName = "/Users/bipo/Downloads/111.xlsx";

        EasyExcel.write(fileName)
                .registerWriteHandler(new MyCellColorStrategy())
                .head(getHead()).sheet("模板")
                .doWrite(getData());
    }
}
