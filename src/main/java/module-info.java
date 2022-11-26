module com.example.wilson_juancamilolab5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.datatransfer;
    requires java.desktop;

    opens com.example.wilson_juancamilolab5 to javafx.fxml;
    exports com.example.wilson_juancamilolab5;
}