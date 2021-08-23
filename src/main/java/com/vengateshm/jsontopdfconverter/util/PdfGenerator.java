package com.vengateshm.jsontopdfconverter.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.vengateshm.jsontopdfconverter.dto.OrderDto;
import com.vengateshm.jsontopdfconverter.request.BillRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class PdfGenerator {
    private static final Logger logger = LoggerFactory.getLogger(PdfGenerator.class);

    public static ByteArrayInputStream generateBillPdf(BillRequest billRequest) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfPTable table = new PdfPTable(4);
            table.setWidths(new int[]{3, 2, 2, 3});

            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell headerCell;
            headerCell = new PdfPCell(new Phrase("ITEM", headerFont));
            headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(headerCell);

            headerCell = new PdfPCell(new Phrase("RATE", headerFont));
            headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(headerCell);

            headerCell = new PdfPCell(new Phrase("QTY", headerFont));
            headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(headerCell);

            headerCell = new PdfPCell(new Phrase("AMT", headerFont));
            headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(headerCell);

            Font cellFont = FontFactory.getFont(FontFactory.HELVETICA);

            for (OrderDto orderDto : billRequest.getOrders()) {
                PdfPCell cell;

                cell = new PdfPCell(new Phrase(orderDto.getItemName(), cellFont));
                cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(String.valueOf(orderDto.getRate()), cellFont));
                cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(String.valueOf(orderDto.getQuantity()), cellFont));
                cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(String.valueOf(orderDto.getAmount()), cellFont));
                cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);
            document.close();
        } catch (DocumentException e) {
            logger.error("Error occurred {0} : ", e);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    public static ByteArrayInputStream generateAppNamePdf(String name, String author) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            Paragraph paragraph = new Paragraph();
            paragraph.add(new Paragraph(" "));// New line
            paragraph.add(new Paragraph(name, new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD)));// New line
            paragraph.add(new Paragraph(" "));// New line
            paragraph.add(new Paragraph("Created by " + author, new Font(Font.FontFamily.HELVETICA, 14, Font.NORMAL)));// New line

            PdfWriter.getInstance(document, out);
            document.open();
            // Add metadata
            document.addAuthor(author);

            document.add(paragraph);

            document.close();
        } catch (DocumentException e) {
            logger.error("Error occurred {0} : ", e);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
