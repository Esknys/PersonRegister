package com.example.personregister;

import javafx.scene.control.Alert;

public class InputException  extends Exception {
    public InputException(String msg) {
        super(msg);

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Feil!");
        alert.setHeaderText("Ugyldig data!");
        alert.setContentText("Du må taste inn gyldig data!");
        alert.showAndWait();
    }
}
