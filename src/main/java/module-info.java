module com.tris {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.tris;
    opens com.tris to javafx.fxml;
}