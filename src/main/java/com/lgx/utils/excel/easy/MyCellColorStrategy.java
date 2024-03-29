package com.lgx.utils.excel.easy;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.util.BooleanUtils;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.handler.context.CellWriteHandlerContext;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.*;

public class MyCellColorStrategy implements CellWriteHandler {

    private Workbook workbook;

    private CellStyle cellStyle;

    /**
     * 在创建单元格之前调用
     */
    @Override
    public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Head head, Integer columnIndex, Integer relativeRowIndex, Boolean isHead) {

    }

    /**
     * 在单元格创建后调用
     */
    @Override
    public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {

    }

    public void afterCellDispose(CellWriteHandlerContext context) {
        if (BooleanUtils.isNotTrue(context.getHead())) {
            Cell cell = context.getCell();

            //Cell Styles 64000 个限制，避免重复创建对象
            if (workbook == null) {
                System.out.println("111");
                workbook = context.getWriteWorkbookHolder().getWorkbook();
            }
            if (cellStyle == null) {
                System.out.println("222");
                cellStyle = workbook.createCellStyle();
            }

            String stringCellValue = cell.getStringCellValue();
            if (stringCellValue.equals("B333")) {
                Font writeFont = workbook.createFont();
                writeFont.setColor(IndexedColors.RED.getIndex());
                cellStyle.setFont(writeFont);
                cell.setCellStyle(cellStyle);
                context.getFirstCellData().setWriteCellStyle(null);
            }
        }
    }
}
