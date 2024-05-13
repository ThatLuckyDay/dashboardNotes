package com.stand_alone.docs.controllers;

import com.stand_alone.docs.services.ProgramFileService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;

@Controller
public class CreateFileController {
    private final ProgramFileService programFileService;

    @Getter
    @Setter
    private Stage stage;

    @Getter
    private final URL fxmlPath = CreateFileController.class.getResource("/create_object.fxml");

    @FXML
    private TextField codeField;

    @FXML
    private TextField nameField;

    @Autowired
    public CreateFileController(ProgramFileService programFileService) {
        this.programFileService = programFileService;
    }

    @FXML
    private void initialize() {
    }

    public void showWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlPath);
        fxmlLoader.setControllerFactory(bean -> this);
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        stage = new Stage();
        stage.setTitle("Создание объекта");
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    private void handleCreate() {

        stage.close();
    }

    @FXML
    private void handleReject() {
        stage.close();
    }

}
