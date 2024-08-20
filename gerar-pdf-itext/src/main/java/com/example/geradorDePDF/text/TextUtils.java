package com.example.geradorDePDF.text;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class TextUtils {
    // Método para adicionar texto ao PDF
    public static void addText(Document document, String text) throws DocumentException {
        Paragraph paragraph = new Paragraph(text);
        document.add(paragraph);
    }

    public static void createPdfWithText(String filename, String text) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();
            addText(document, text);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
