package com.herb.rhythm.music;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.AudioSpectrumListener;

import java.io.File;

public class AudioInput {
    private volatile double[] currentSpectrum;
    private MediaPlayer mediaPlayer;
    private static final int BAR_COUNT = 32;

    public AudioInput(File file) {
        this.currentSpectrum = new double[BAR_COUNT];
        Media media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAudioSpectrumNumBands(BAR_COUNT);
        mediaPlayer.setAudioSpectrumInterval(1.0 / 60.0);
        mediaPlayer.setAudioSpectrumListener((timestamp, duration, magnitudes, phases) -> {
            for (int i = 0; i < BAR_COUNT; i++) {
                // magnitudes are in dB, typically -60 to 0; normalize to 0..1
                double normalized = (magnitudes[i] + 60.0) / 60.0;
                if (normalized < 0) normalized = 0;
                if (normalized > 1) normalized = 1;
                currentSpectrum[i] = normalized;
            }
        });
    }

    public void start() {
        if (mediaPlayer != null) mediaPlayer.play();
    }

    public void stop() {
        if (mediaPlayer != null) mediaPlayer.stop();
    }

    public double[] getCurrentSpectrum() {
        return currentSpectrum.clone();
    }
}
