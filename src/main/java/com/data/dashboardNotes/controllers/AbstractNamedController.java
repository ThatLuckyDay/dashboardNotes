package com.data.dashboardNotes.controllers;

import com.data.dashboardNotes.view.Menu;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public abstract class AbstractNamedController {
    @FXML
    private Label title;

    public void setTitle(Menu menu) {
        this.title.setText(menu.getTitle());
    }
}
