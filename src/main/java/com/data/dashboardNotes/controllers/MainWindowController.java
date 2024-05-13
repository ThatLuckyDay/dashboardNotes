package com.data.dashboardNotes.controllers;

import com.data.dashboardNotes.DashboardNotesUIStarter;
import com.data.dashboardNotes.DashboardNotesUIStarter.StageReadyEvent;
import com.data.dashboardNotes.view.Menu;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;

@Component
public class MainWindowController {

    @Value("classpath:/windows/pages/mainWindow.fxml")
    private Resource mainWindowFxmlResource;

    private final String applicationTitle;

    @FXML
    private VBox sideBar;

    @FXML
    private StackPane contentView;

    @Autowired
    public MainWindowController(@Value("${application.title}") String applicationTitle) {
        this.applicationTitle = applicationTitle;
    }

    @FXML
    public void initialize() {
        loadContentView(Menu.DEVICES);
    }

    public void loadView(StageReadyEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(mainWindowFxmlResource.getURL());
            fxmlLoader.setControllerFactory(DashboardNotesUIStarter.getApplicationContext()::getBean);
            Parent parent = fxmlLoader.load();

            Stage stage = event.getStage();
            stage.setTitle(applicationTitle);
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @FXML
    private void clickSideBarItem(MouseEvent event) {
        Node node = (Node) event.getSource();
        Menu menu = Menu.valueOf(node.getId());
        loadContentView(menu);

    }

    private void loadContentView(Menu menu) {
        try {
            /* Выделить пункт меню */
            for (Node node : sideBar.getChildren()) {
                node.getStyleClass().remove("active");
                if (node.getId().equals(menu.name())) {
                    node.getStyleClass().add("active");
                }
            }

            /* Показать содержание страницы */
            contentView.getChildren().clear();
            URL contentURL = new URL(menu.getFxml());
            FXMLLoader fxmlLoader = new FXMLLoader(contentURL);
            fxmlLoader.setControllerFactory(DashboardNotesUIStarter.getApplicationContext()::getBean);
            Parent view = fxmlLoader.load();

            /* Показать заголовок страницы */
            AbstractNamedController controller = fxmlLoader.getController();
            controller.setTitle(menu);

            contentView.getChildren().add(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
