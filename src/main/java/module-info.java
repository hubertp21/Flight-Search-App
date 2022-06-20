module com.example.flightmanageapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires javax.persistence;

    opens com.example.flightmanageapp to javafx.fxml;
    exports com.example.flightmanageapp;
    exports utils;
    opens utils to javafx.fxml;
    exports entitiesAndMappings;
    opens entitiesAndMappings to javafx.fxml;
}