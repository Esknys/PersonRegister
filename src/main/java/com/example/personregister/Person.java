package com.example.personregister;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;
import java.time.LocalDate;

public class Person {

    private SimpleStringProperty navn;
    private SimpleStringProperty alder;
    private LocalDate foedselsdato;

    private SimpleStringProperty epost;

    private SimpleStringProperty telefonnummer;

    public Person (String navn1, String alder1, LocalDate foedselsdato1, String epost1, String telefonnummer1) throws InputException {

        if (PersonValidator.ValidateNavn(navn1) && PersonValidator.ValidateAlder(alder1) && PersonValidator.ValidateFoedselsdato(foedselsdato1) && PersonValidator.ValidateEpost(epost1) && PersonValidator.ValidateTelefonnummer(telefonnummer1)) {

            this.navn = new SimpleStringProperty(navn1);
            this.alder = new SimpleStringProperty(alder1);
            this.foedselsdato = foedselsdato1;
            this.epost = new SimpleStringProperty(epost1);
            this.telefonnummer = new SimpleStringProperty(telefonnummer1);
        }
    }

    public String getNavn() {
        return navn.getValue();
    }

    public void setNavn(String navn1) {
        this.navn = new SimpleStringProperty(navn1);
    }

    public String getAlder() {
        return alder.getValue();
    }

    public void setAlder(String alder1) {
        this.alder = new SimpleStringProperty(alder1);
    }

    public LocalDate getFoedselsdato() {
        return foedselsdato;
    }

    public void setFoedselsdato(LocalDate foedselsdato1) {
        this.foedselsdato = foedselsdato1;
    }

    public String getEpost() {
        return epost.getValue();
    }

    public void setEpost(String epost1) {
        this.epost = new SimpleStringProperty(epost1);
    }

    public String getTelefonnummer() {
        return telefonnummer.getValue();
    }

    public void setTelefonnummer(String telefonnummer1) {
        this.telefonnummer = new SimpleStringProperty(telefonnummer1);
    }

    public String toString() {
        return String.format(navn.getValue() + ";" + alder.getValue() + ";" + foedselsdato + ";" + epost.getValue() + ";" + telefonnummer.getValue());
    }
}
