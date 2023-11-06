module com.comp2059.snakegame {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    //requires javafx.media;


    opens com.comp2059.snakegame to javafx.fxml;
    exports com.comp2059.snakegame;
}
