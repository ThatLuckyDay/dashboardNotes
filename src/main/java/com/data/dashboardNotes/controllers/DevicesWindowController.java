package com.data.dashboardNotes.controllers;

import com.data.dashboardNotes.model.Device;
import com.data.dashboardNotes.service.DeviceService;
import com.data.dashboardNotes.view.DeviceView;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DevicesWindowController extends AbstractNamedController {

    @FXML
    private VBox devicesBox;

    private final DeviceService service;

    private final DeviceCreateWindowController deviceCreateWindowController;

    @Autowired
    public DevicesWindowController(DeviceService service,
                                   DeviceCreateWindowController deviceCreateWindowController) {
        this.service = service;
        this.deviceCreateWindowController = deviceCreateWindowController;
    }

    @FXML
    private void initialize() {
        /* Показать устройства */
        devicesBox.getChildren().clear();
        List<Device> types = service.findAllTypes();
        if (types != null) {
            types.forEach(device ->
                    devicesBox.getChildren()
                            .add(new DeviceView(device)));
        }
    }

    public void refresh() {
        devicesBox.getChildren().clear();
        List<Device> types = service.findAllTypes();
        if (types != null) {
            types.forEach(device ->
                    devicesBox.getChildren()
                            .add(new DeviceView(device)));
        }
    }

    @FXML
    private void createDevice() {
        deviceCreateWindowController.loadView();
        refresh();
    }

    @FXML
    private void editDevice() {

    }

    @FXML
    private void deleteDevice() {

    }

}
