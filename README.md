# Music Visualizer

A real-time music visualizer built with JavaFX. Load any audio file and watch a rainbow spectrum dance to the beat.

## Requirements

- Java 17+
- Maven (or use the included `./mvnw` wrapper)

## Run

```bash
./mvnw javafx:run
```

Click anywhere on the window to open a file picker and load an MP3, WAV, or AIFF file. The visualizer starts immediately.

## How it works

- Audio is played back via `javax.sound.sampled`
- Each audio chunk's RMS (loudness) drives 32 spectrum bars with smooth decay
- Bars are rainbow-colored (red → violet) and rendered at ~60 FPS on a JavaFX canvas

> The spectrum is loudness-based, not a true FFT — all bars share the same energy with random variation for visual effect.

## Project structure

```
src/main/java/com/herb/rhythm/music/
├── Launcher.java          # Entry point
├── VisualizerApp.java     # JavaFX window and animation loop
├── AudioInput.java        # Audio playback and spectrum data
└── SpectrumRenderer.java  # Canvas rendering
```
