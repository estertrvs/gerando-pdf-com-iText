package com.example.geradorDePDF.image;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

public class MainImage {
    public static void main(String[] args) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("Imagem.pdf"));
            document.open();

            // Adicionando imagem de exemplo (substitua "path/to/logo.png" pelo caminho real da imagem)
            ImageUtils.addImage(document, "path/to/logo.png");

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
