package com.data.dashboardNotes.view;

import lombok.Getter;

@Getter
public enum Menu {
    DEVICES("Перечень изделий"),
    STATISTIC("Статистика");

    private final String title;

    Menu(String title) {
        this.title = title;
    }

    public String getFxml() {
        return String.format("classpath:/windows/pages/%sWindow.fxml", name().toLowerCase());
    }
}
