package com.data.dashboardNotes.view;

import com.data.dashboardNotes.model.Device;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceView extends VBox {

    private final Device device;

    private Label remark;

    private Label name;

    private Label code;

    public DeviceView(Device device) {
        this.device = device;

        HBox identifier = new HBox();
        name = new Label(device.getType());
        code = new Label(device.getCode());
        identifier.getChildren().addAll(name, code);
        identifier.getStyleClass().add("identifier");

        remark = new Label(device.getRemark());
        remark.getStyleClass().add("remark");

        getChildren().addAll(identifier, remark);
        getStyleClass().add("devices-item");

        setOnMouseClicked(event -> requestFocus());

        Background focusBackground = new Background(
                new BackgroundFill(Color.rgb(220, 242, 241), CornerRadii.EMPTY, Insets.EMPTY)
        );
        Background unfocusBackground = new Background(
                new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)
        );
        backgroundProperty().bind(Bindings
                .when(focusedProperty())
                .then(focusBackground)
                .otherwise(unfocusBackground)
        );
    }


}
