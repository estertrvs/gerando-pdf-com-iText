package com.example.geradorDePDF.text;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

public class MainText {
    public static void main(String[] args) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("Texto.pdf"));
            document.open();

            // Adicionando texto de exemplo
            TextUtils.addText(document, "Mercadinho do Bairro");
            TextUtils.addText(document, "CNPJ: 12.345.678/0001-99");

            // Adicionando data e hora dinâmicas
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String formattedDateTime = now.format(formatter);
            TextUtils.addText(document, "Data e Hora: " + formattedDateTime);

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
