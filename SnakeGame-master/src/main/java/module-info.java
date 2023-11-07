module com.comp2059.snakegame {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    //requires java.desktop;
    //requires javafx.media;

// 导出包给javafx.fxml和javafx.graphics模块
    exports com.comp2059.snakegame to javafx.fxml, javafx.graphics;

    // 如果你有控制器在特定的包中，也需要导出它们
    exports com.comp2059.snakegame.controllers to javafx.fxml, javafx.graphics;

    // 允许javafx.fxml模块使用反射
    opens com.comp2059.snakegame to javafx.fxml;
    opens com.comp2059.snakegame.controllers to javafx.fxml;

}
