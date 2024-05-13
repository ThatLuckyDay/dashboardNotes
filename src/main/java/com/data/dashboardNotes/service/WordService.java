package com.data.dashboardNotes.service;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class WordService {

    @Value("classpath:/templates/response_otk.docx")
    private String FILE_PATH;

    public void updateDocument(String filePath, String text, String marker)
            throws IOException, InvalidFormatException {
        Path path = Paths.get(filePath);
        try (XWPFDocument document = new XWPFDocument(Files.newInputStream(path))) {
            document
                    .getParagraphs()
                    .stream()
                    .flatMap(paragraph -> paragraph.getRuns().stream())
                    .filter(runner -> runner.getText(0) != null)
                    .filter(runner -> runner.getText(0).equals(marker))
                    .forEach(runner -> runner.setText(runner.getText(0).replace(marker, text), 0));
            try (FileOutputStream out = new FileOutputStream(FILE_PATH)) {
                document.write(out);
            }
        }
    }
}
