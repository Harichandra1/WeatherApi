package com.mycompany.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import com.mycompany.app.ui.Ui;

@SpringBootApplication
public class MyApp extends Application {

    public static void main(String[] args) {
        // Start JavaFX in a separate thread
        Thread fxThread = new Thread(() -> Application.launch(Ui.class, args));
        fxThread.start();

        // Start Spring Boot in the main thread
        SpringApplication.run(MyApp.class, args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Spring Boot is running, so you don't need to do anything in this method.
        // The JavaFX UI is launched in a separate thread.
    }

    @Override
    public void stop() {
        Platform.exit();
        System.exit(0);
    }
}