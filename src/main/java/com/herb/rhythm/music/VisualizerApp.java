package com.herb.rhythm.music;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class VisualizerApp extends Application {

    private AudioInput audioInput;
    private SpectrumRenderer renderer;
    private AnimationTimer timer;
    private Canvas canvas;
    private boolean isPlaying = false;

    @Override
    public void start(Stage stage) {
        canvas = new Canvas(800, 600);
        renderer = new SpectrumRenderer(canvas.getGraphicsContext2D(), 800, 600);

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, 800, 600);
        scene.setFill(Color.BLACK);

        scene.setOnMouseClicked(e -> chooseAndPlaySong(stage));

        stage.setTitle("Music Visualizer – #remixed");
        stage.setScene(scene);
        stage.show();

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (isPlaying && audioInput != null) {
                    renderer.render(audioInput.getCurrentSpectrum());
                }
            }
        };
        timer.start();
    }

    private void chooseAndPlaySong(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Audio Files", "*.mp3", "*.wav", "*.aiff")
        );
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            if (audioInput != null) audioInput.stop();
            audioInput = new AudioInput(file);
            audioInput.start();
            isPlaying = true;
        }
    }

    public static void main(String[] args) { launch(args); }
}
