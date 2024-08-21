package com.example.geradorDePDF.image;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class ImageUtils {
    // Método para adicionar uma imagem ao PDF
    public static void addImage(Document document, String imagePath) throws DocumentException, IOException {
        Image image = Image.getInstance(imagePath);
        document.add(image);
    }

    public static void createPdfWithImage(String filename, String imagePath) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();
            addImage(document, imagePath);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
