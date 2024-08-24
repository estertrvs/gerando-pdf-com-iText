package com.example.geradorDePDF.image;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

public class MainImage {
	
    public static void main(String[] args) throws URISyntaxException, IOException {
    	
    	Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("ImagemIfpbMonteiro.pdf"));
            document.open();

            ImageUtils.addImage(document, Imagens.LOGO_IFPB_CAMPUS_MONTEIRO);
            
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
        	document.close();
        }
    }
}
