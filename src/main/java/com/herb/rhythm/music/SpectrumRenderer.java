package com.herb.rhythm.music;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SpectrumRenderer {
    private GraphicsContext gc;
    private double width, height;

    public SpectrumRenderer(GraphicsContext gc, double width, double height) {
        this.gc = gc;
        this.width = width;
        this.height = height;
    }

    public void render(double[] spectrum) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, width, height);

        int barCount = spectrum.length;
        double barWidth = width / barCount;

        for (int i = 0; i < barCount; i++) {
            double barHeight = spectrum[i] * (height - 50);
            double x = i * barWidth;
            double y = height - barHeight - 20;

            Color barColor = Color.hsb(360.0 * i / barCount, 1.0, 0.8);
            gc.setFill(barColor);
            gc.fillRect(x, y, barWidth - 2, barHeight);
        }

        gc.setFill(Color.WHITE);
        gc.fillText("Playing... press anywhere to load new song", 20, height - 10);
    }
}
