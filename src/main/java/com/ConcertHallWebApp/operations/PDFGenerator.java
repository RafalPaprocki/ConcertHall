package com.ConcertHallWebApp.operations;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.stream.Stream;

import com.ConcertHallWebApp.model.Event;
import com.ConcertHallWebApp.model.Ticket;
import com.ConcertHallWebApp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFGenerator {

    private static Logger logger = LoggerFactory.getLogger(PDFGenerator.class);

    public void saveTicketPDF(Event event, User user){
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("ticket4.pdf"));
            document.open();
            Font font = FontFactory.getFont(FontFactory.COURIER, 24, BaseColor.BLACK);
            Chunk chunk = new Chunk("Bilet na koncert", font);
            Paragraph paragraph = new Paragraph(50);
            paragraph.add(chunk);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            paragraph.setSpacingAfter(50);
            document.add(paragraph);
            PdfPTable table = new PdfPTable(3);
            addTableHeader(table);
            addRows(table);

            document.add(table);
            document.close();
        }
        catch(Exception e){
            System.out.println();
        }
    }

    private void addTableHeader(PdfPTable table) {
        Stream.of("column header 1", "column header 2", "column header 3")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    private void addRows(PdfPTable table) {
        table.addCell("row 1, col 1");
        table.addCell("row 1, col 2");
        table.addCell("row 1, col 3");
    }


    public static ByteArrayInputStream customerPDFReport(List<Ticket> customers) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();
            // Add Text to PDF file ->
            Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
            Paragraph para = new Paragraph( "Customer Table", font);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(3);
            // Add PDF Table Header ->
            Stream.of("ID", "First Name", "Last Name")
                    .forEach(headerTitle -> {
                        PdfPCell header = new PdfPCell();
                        Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        header.setHorizontalAlignment(Element.ALIGN_CENTER);
                        header.setBorderWidth(2);
                        header.setPhrase(new Phrase(headerTitle, headFont));
                        table.addCell(header);
                    });

            for (Ticket ticket : customers) {
                PdfPCell idCell = new PdfPCell(new Phrase(ticket.getId().toString()));
                idCell.setPaddingLeft(4);
                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(idCell);

                PdfPCell firstNameCell = new PdfPCell(new Phrase(ticket.getPrice().toString()));
                firstNameCell.setPaddingLeft(4);
                firstNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                firstNameCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(firstNameCell);

                PdfPCell lastNameCell = new PdfPCell(new Phrase(String.valueOf(ticket.getPrice().toString())));
                lastNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                lastNameCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                lastNameCell.setPaddingRight(4);
                table.addCell(lastNameCell);
            }
            document.add(table);

            document.close();
        }catch(DocumentException e) {
            logger.error(e.toString());
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}