package com.data.dashboardNotes.controllers;

import com.data.dashboardNotes.DashboardNotesUIStarter;
import com.data.dashboardNotes.model.Device;
import com.data.dashboardNotes.service.DeviceService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class DeviceCreateWindowController {
    @Value("classpath:/windows/pages/deviceCreateWindow.fxml")
    private Resource pageFxmlResource;

    private Stage stage;

    private DeviceService service;

    @Autowired
    public DeviceCreateWindowController(DeviceService service) {
        this.service = service;
    }

    @FXML
    public void initialize() {
        stage = new Stage();
    }

    public void loadView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(pageFxmlResource.getURL());
            fxmlLoader.setControllerFactory(DashboardNotesUIStarter.getApplicationContext()::getBean);
            Parent view = fxmlLoader.load();
            Scene scene = new Scene(view);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(ActionEvent actionEvent) {
        service.saveDevice(new Device(null, "Transparent Cat", "000.000.000", null));
        stage.close();
    }

    public void close(ActionEvent actionEvent) {
        stage.close();
    }
}
