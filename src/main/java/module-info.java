module org.example.socketclientserver {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.socketclientserver to javafx.fxml;
    exports org.example.socketclientserver;
}