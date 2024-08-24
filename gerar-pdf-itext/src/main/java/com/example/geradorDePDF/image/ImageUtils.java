package com.example.geradorDePDF.image;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

public class ImageUtils {
    // Método para adicionar uma imagem ao PDF
    public static void addImage(Document document, String imagePath) throws DocumentException, IOException {
        Image image = Image.getInstance(imagePath);
        document.add(image);
    }

    public void createPdfWithImage(String filename, String imagePath) {
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
