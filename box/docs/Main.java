package com.stand_alone.docs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.net.URL;

@SpringBootApplication
public class Main extends Application {
    private Parent parent;
    private ConfigurableApplicationContext springContext;
    private final URL fxmlPath = Main.class.getResource("/mainWindow.fxml");

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Помошник Git");
        Scene scene = new Scene(parent, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(Main.class);
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlPath);
        fxmlLoader.setControllerFactory(springContext::getBean);
        parent = fxmlLoader.load();
    }

    @Override
    public void stop() {
        springContext.close();
    }
}
