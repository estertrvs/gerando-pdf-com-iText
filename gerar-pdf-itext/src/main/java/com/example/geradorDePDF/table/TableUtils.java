package com.example.geradorDePDF.table;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class TableUtils {
    // Método para adicionar uma tabela ao PDF
    public static void addTable(Document document) throws DocumentException {
        PdfPTable table = new PdfPTable(3); // 3 colunas

        // Adiciona o cabeçalho da tabela
        table.addCell("Produto");
        table.addCell("Quantidade");
        table.addCell("Preço Unitário");

        // Adiciona dados de exemplo
        table.addCell("Arroz");
        table.addCell("2");
        table.addCell("R$ 10,00");

        table.addCell("Feijão");
        table.addCell("1");
        table.addCell("R$ 8,00");

        table.addCell("Óleo");
        table.addCell("3");
        table.addCell("R$ 6,00");

        document.add(table);
    }

    public static void createPdfWithTable(String filename) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();
            addTable(document);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}