package com.example.personregister;

import java.io.Serializable;
import java.util.ArrayList;

public class PersonRegisterJobj implements Serializable {

    public ArrayList<PersonJobj> personer;

    public PersonRegisterJobj(ArrayList<PersonJobj> personer1) {
        this.personer = personer1;
    }

    public ArrayList<PersonJobj> getPersoner() {
        return personer;
    }

    public void setPersoner(ArrayList<PersonJobj> personer1) {
        this.personer = personer1;
    }

    public void addPersoner(PersonJobj person) {
        personer.add(person);
    }
}
