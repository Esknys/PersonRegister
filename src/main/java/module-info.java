module com.example.avvikshaandtering {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.personregister to javafx.fxml;
    exports com.example.personregister;
}