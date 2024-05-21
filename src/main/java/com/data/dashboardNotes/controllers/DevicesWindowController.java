package com.data.dashboardNotes.controllers;

import com.data.dashboardNotes.model.Device;
import com.data.dashboardNotes.service.DeviceService;
import com.data.dashboardNotes.view.DeviceView;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
        refresh();
    }

    public void refresh() {
        devicesBox.getChildren().clear();
        List<Device> types = service.findAllTypes();
        if (types != null) {
            types.forEach(device -> devicesBox.getChildren().add(new DeviceView(device)));
        }

        for (Node elem : devicesBox.getChildren()) {
            VBox vBox = (VBox) elem;
            vBox.setOnMouseClicked(event ->
            {
                vBox.requestFocus();
            });
            Background focusBackground = new Background(new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, Insets.EMPTY));
            Background unfocusBackground = new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY));

            vBox.backgroundProperty().bind(Bindings
                    .when(vBox.focusedProperty())
                    .then(focusBackground)
                    .otherwise(unfocusBackground)
            );

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
