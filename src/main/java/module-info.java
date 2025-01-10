module com.example.loginscriptjfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.loginscriptjfx to javafx.fxml;
    exports com.example.loginscriptjfx;
    exports com.example.loginscriptjfx.controller;
    opens com.example.loginscriptjfx.controller to javafx.fxml;
}