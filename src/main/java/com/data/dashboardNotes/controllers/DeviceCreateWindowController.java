package com.data.dashboardNotes.controllers;

import com.data.dashboardNotes.DashboardNotesUIStarter;
import com.data.dashboardNotes.model.Device;
import com.data.dashboardNotes.service.DeviceService;
import com.data.dashboardNotes.view.DeviceView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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

    @FXML
    private TextField name;

    @FXML
    private TextField code;

    @FXML
    private TextArea remark;

    private final DeviceService service;

    private DeviceView deviceView;

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
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadView(DeviceView deviceView) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(pageFxmlResource.getURL());
            fxmlLoader.setControllerFactory(DashboardNotesUIStarter.getApplicationContext()::getBean);
            Parent view = fxmlLoader.load();
            Scene scene = new Scene(view);
            stage.setScene(scene);

            this.deviceView = deviceView;
            name.setText(deviceView.getName().getText());
            code.setText(deviceView.getCode().getText());
            remark.setText(deviceView.getRemark().getText());

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(ActionEvent actionEvent) {
        Device device;
        if (deviceView == null) {
            device = new Device();
        } else {
            device = deviceView.getDevice();
            deviceView.getName().setText(name.getText());
            deviceView.getCode().setText(code.getText());
            deviceView.getRemark().setText(remark.getText());
        }

        device.setType(name.getText());
        device.setCode(code.getText());
        device.setRemark(remark.getText());

        service.saveDevice(device);
        stage.close();
    }

    public void close(ActionEvent actionEvent) {
        stage.close();
    }
}
