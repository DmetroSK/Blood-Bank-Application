
module com.teambeta.bloodbank {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.java;


    opens com.teambeta.bloodbank to javafx.fxml;
    exports com.teambeta.bloodbank;
}