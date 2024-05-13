package com.stand_alone.docs.controllers;

import com.stand_alone.docs.services.ProgramFileService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;

@Controller
public class DeleteFileController {
    private final ProgramFileService programFileService;

    @Getter
    @Setter
    private Stage stage;

    @Getter
    private final URL fxmlPath = CreateFileController.class.getResource("/create_object.fxml");


    @Autowired
    public DeleteFileController(ProgramFileService programFileService) {
        this.programFileService = programFileService;
    }

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
}
