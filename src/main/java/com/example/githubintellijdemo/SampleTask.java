package com.example.githubintellijdemo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SampleTask extends Application {
    private ObservableList<String> tasks = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        Label lbl = new Label("Enter task:");
        TextField tf = new TextField();
        tf.setPromptText("Type something");
        Button btnAdd = new Button("Add Task");
        HBox inputBox = new HBox(10, lbl, tf, btnAdd);
        inputBox.setPadding(new Insets(10));
        ListView<String> taskListView = new ListView<>(tasks);
        Label status = new Label("No tasks yet");
        BorderPane root = new BorderPane();
        root.setTop(inputBox);
        root.setCenter(taskListView);
        root.setBottom(status);
        BorderPane.setMargin(status, new Insets(10));
        btnAdd.setOnAction(e -> {
            String text = tf.getText().trim();
            if (!text.isEmpty()) {
                tasks.add(text);
                tf.clear();
                status.setText("Added task: \"" + text + "\"");
            } else {
                status.setText("Cannot add empty task.");
            }
        });

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Mock Task App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
