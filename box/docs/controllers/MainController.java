package com.stand_alone.docs.controllers;

import com.stand_alone.docs.services.ProgramFileService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.IOException;

@Controller
public class MainController {
    private final CreateFileController directoryWindow;

    private final ProgramFileService programFileService;

    @Autowired
    public MainController(CreateFileController directoryWindow,
                          ProgramFileService programFileService) {
        this.directoryWindow = directoryWindow;
        this.programFileService = programFileService;
    }

    @FXML
    public void initialize() {
    }

    @FXML
    private void setDirectory(ActionEvent actionEvent) throws IOException {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        Stage stage = new Stage();
        stage.setTitle("Укажите путь к основной дирректории");
        File directory = directoryChooser.showDialog(stage);
        if (directory != null) {
        }
    }

    @FXML
    private void createEntry(ActionEvent actionEvent) throws GitAPIException, IOException {
    }

    @FXML
    private void deleteEntry(ActionEvent actionEvent) throws GitAPIException, IOException {
    }

    private void switchWindowsBack(String fileName) {
    }

    private void switchWindowsForward(String fileName) {
    }

    private void showFileDetails(String fileName) {
    }

}