package com.data.dashboardNotes.controllers;

import com.data.dashboardNotes.model.Device;
import com.data.dashboardNotes.service.DeviceService;
import com.data.dashboardNotes.view.DeviceView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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

    private final ObservableList<DeviceView> devices = FXCollections.observableArrayList();

    @Autowired
    public DevicesWindowController(DeviceService service,
                                   DeviceCreateWindowController deviceCreateWindowController) {
        this.service = service;
        this.deviceCreateWindowController = deviceCreateWindowController;
    }

    @FXML
    private void initialize() {
        createDeviceViewList();
        refresh();
    }

    public void refresh() {
        devicesBox.getChildren().clear();
        devicesBox.getChildren().addAll(devices);
    }

    public void createDeviceViewList() {
        List<DeviceView> deviceViewList = service
                .findAllTypes()
                .stream()
                .map(DeviceView::new)
                .toList();
        devices.clear();
        devices.addAll(deviceViewList);
    }

    @FXML
    private void createDevice() {
        deviceCreateWindowController.loadView();
        createDeviceViewList();
        refresh();
    }

    @FXML
    private void editDevice() {
        DeviceView selectedDevice = (DeviceView) devicesBox
                .getChildren()
                .stream()
                .filter(Node::isFocused)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не выбран объект"));

        deviceCreateWindowController.loadView(selectedDevice);
    }

    @FXML
    private void deleteDevice() {
        DeviceView selectedDevice = (DeviceView) devicesBox
                .getChildren()
                .stream()
                .filter(Node::isFocused)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не выбран объект"));

        service.deleteDevice(selectedDevice.getDevice());

        devices.remove(selectedDevice);
        devicesBox.getChildren().remove(selectedDevice);
    }

}
