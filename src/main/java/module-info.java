module rygatoni.github.io.project4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires org.junit.jupiter.api;

    opens rygatoni.github.io.project_4 to javafx.fxml;
    exports rygatoni.github.io.project_4;
}