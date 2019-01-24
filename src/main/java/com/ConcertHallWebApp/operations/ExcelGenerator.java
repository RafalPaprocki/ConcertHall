package com.ConcertHallWebApp.operations;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import com.ConcertHallWebApp.model.Event;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelGenerator {

    public static ByteArrayInputStream customersToExcel(List<Event> events) throws IOException {
        String[] COLUMNs = {"Id", "Nazwa wydarzenia", "Data", "Godzina rozpoczęcia", "Cena"};
        try(
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();
        ){
            CreationHelper createHelper = workbook.getCreationHelper();

            Sheet sheet = workbook.createSheet("Events");

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            Row headerRow = sheet.createRow(0);

            for (int col = 0; col < COLUMNs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(COLUMNs[col]);
                cell.setCellStyle(headerCellStyle);
            }

            CellStyle ageCellStyle = workbook.createCellStyle();
            ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));

            int rowIdx = 1;
            for (Event event : events) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(event.getId().toString());
                row.createCell(1).setCellValue(event.getName() != null ? event.getName() : "brak");
                if(event.getDate() != null){
                    row.createCell(2).setCellValue(event.getDate().toString());
                }
                else {
                    row.createCell(2).setCellValue("nieokreślono");
                }
                row.createCell(3).setCellValue(event.getStartTime() != null ? event.getStartTime().toString() : "brak");
                row.createCell(4).setCellValue(event.getPrice() != null ? event.getPrice().toString() : "brak");
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}