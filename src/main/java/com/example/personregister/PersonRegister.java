package com.example.personregister;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class PersonRegister {

    public ObservableList<Person> personer;

    public void attachTableView(TableView tableView) {
        tableView.setItems(personer);
    }

    public PersonRegister(ObservableList<Person> personer1) {
        this.personer = personer1;
    }

    public ObservableList<Person> getPersoner() {
        return personer;
    }

    public void setPersoner(ObservableList<Person> personer1) {
        this.personer = personer1;
    }

    public void addPersoner(Person person) {
        personer.add(person);
    }
}
