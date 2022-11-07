module com.wassabi {
    requires java.sql;
    requires java.desktop;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires transitive java.persistence;
    requires transitive javafx.graphics;
    
    exports com.wassabi;
    exports com.wassabi.gui;
    exports com.wassabi.model;
    opens com.wassabi.gui to javafx.fxml, org.hibernate.orm.core;
}
