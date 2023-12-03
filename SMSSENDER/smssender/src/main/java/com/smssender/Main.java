package com.smssender;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/SmsSenderUI.fxml"));
        Parent root = loader.load();

        SmsSenderController controller = loader.getController();

        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("SMS Sender");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
