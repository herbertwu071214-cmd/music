# Music Visualizer (#remixed)

This project started because I’ve always been fascinated by how sound looks when you break it down. I didn't just want to hear the bass or the treble; I wanted to see the energy of my music moving in real-time. I wanted something "settled down the smart way"—a simple, clean visualizer that stays out of the way but makes the listening experience feel a bit more alive.

## What is Music Visualizer?

Music Visualizer is a JavaFX-based application that transforms your local audio files into a reactive frequency spectrum. It’s built to be lightweight and straightforward—no complex menus, no heavy overhead. You just load a song, and the app handles the math to map those frequencies into a vibrant, rainbow-colored display that reacts to every beat.

### Key Features:
- **Real-time Spectrum Analysis:** Uses 32-band frequency mapping to show exactly what's happening in your audio.
- **Dynamic HSB Rendering:** A smooth, color-shifting aesthetic that maps the spectrum across the full HSB color wheel.
- **Format Support:** Handles `.mp3`, `.wav`, and `.aiff` files so you can throw almost anything at it.
- **Zero-Friction UI:** Just click anywhere on the screen to swap tracks and keep the flow going.

---

## How to Replicate (Development Setup)

If you want to run this yourself or see how the frequency mapping works under the hood, here is how you can set it up. Just like arranging things before a club meeting, having the right environment makes all the difference.

### 1. Prerequisites
- **Java 17 or higher:** This project leverages JavaFX 21 and requires at least JDK 17.
- **Maven:** For managing dependencies (the `mvnw` wrapper is also included in the root if you don't have Maven installed globally).

### 2. Clone the Repository
```bash
git clone https://github.com/herbertwu071214-cmd/music-visualizer.git
cd music-visualizer
```

### 3. Build and Run
You can launch the application directly using the JavaFX Maven plugin:
```bash
./mvnw javafx:run
```
Or, if you want to package it into a runnable JAR:
```bash
./mvnw clean package
java -jar target/music-visualizer-1.0-SNAPSHOT.jar
```

### 4. How to Use
- Once the app opens, click anywhere on the black canvas.
- Select your favorite audio file from the file chooser.
- Sit back and watch the music "remix" itself into a visual spectrum!
