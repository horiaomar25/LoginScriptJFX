module com.example.loginscriptjfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.loginscriptjfx to javafx.fxml;
    exports com.example.loginscriptjfx;
}