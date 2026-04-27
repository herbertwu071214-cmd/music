module com.herb.rhythm.music {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.media;
    requires java.desktop;

    opens com.herb.rhythm.music to javafx.fxml;
    exports com.herb.rhythm.music;
}
