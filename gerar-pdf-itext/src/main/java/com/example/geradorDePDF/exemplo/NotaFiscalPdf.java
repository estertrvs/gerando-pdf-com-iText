package com.example.geradorDePDF.exemplo;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.geradorDePDF.text.TextUtils;
import com.example.geradorDePDF.table.TableUtils;

public class NotaFiscalPdf {
    public static void generateNotaFiscal(String filename) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();

            // Adicionando o nome da empresa e o CNPJ
            TextUtils.addText(document, "Mercadinho do Bairro");
            TextUtils.addText(document, "CNPJ: 12.345.678/0001-99");

            // Adicionando a data e a hora da compra
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            TextUtils.addText(document, "Data e Hora: " + now.format(formatter));

            // Adicionar um parágrafo vazio para criar espaço
            document.add(new Paragraph(" "));

            // Adicionando a tabela com os produtos
            TableUtils.addTable(document);

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
