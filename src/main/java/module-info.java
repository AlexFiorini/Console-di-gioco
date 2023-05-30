module com.example.console_di_gioco {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.console_di_gioco to javafx.fxml;
    exports com.console_di_gioco;
    opens com.tris to javafx.fxml;
    exports com.tris;
    opens com.tris_bot to javafx.fxml;
    exports com.tris_bot;
    opens com.forza4 to javafx.fxml;
    exports com.forza4;
    opens com.forza4_bot to javafx.fxml;
    exports com.forza4_bot;
}