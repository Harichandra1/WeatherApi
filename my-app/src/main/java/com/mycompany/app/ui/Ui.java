package com.mycompany.app.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.json.JSONObject;
import com.mycompany.app.App;  // Add this import

public class Ui extends Application {
    private Label temperatureLabel;
    private Label conditionLabel;
    
    @Override
    public void start(Stage primaryStage) {
        // Create UI elements
        Label cityLabel = new Label("Enter a city:");
        TextField cityField = new TextField();
        Button searchButton = new Button("Get Weather");
        temperatureLabel = new Label();
        conditionLabel = new Label();
        
        // Set action for the search button
        searchButton.setOnAction(event -> {
            String city = cityField.getText();
            String response = App.getWeatherData(city);
            if (response.startsWith("API request failed") || response.startsWith("Exception")) {
                temperatureLabel.setText(response);
                conditionLabel.setText("");
            } else {
                parseAndDisplayWeatherData(response);
            }
        });
        
        // Create the layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(cityLabel, cityField, searchButton, temperatureLabel, conditionLabel);
        
        // Create the scene and set it on the stage
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Weather App");
        primaryStage.show();
    }
    
    private void parseAndDisplayWeatherData(String response) {
        try {
            JSONObject jsonResponse = new JSONObject(response);
            JSONObject location = jsonResponse.getJSONObject("location");
            JSONObject current = jsonResponse.getJSONObject("current");
            double tempC = current.getDouble("temp_c");
            String condition = current.getJSONObject("condition").getString("text");
            temperatureLabel.setText("Temperature: " + tempC + "°C");
            conditionLabel.setText("Condition: " + condition);
        } catch (Exception e) {
            e.printStackTrace();
            temperatureLabel.setText("Error parsing weather data.");
            conditionLabel.setText("");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}