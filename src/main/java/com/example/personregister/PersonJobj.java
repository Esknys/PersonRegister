package com.example.personregister;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;
import java.time.LocalDate;

public class PersonJobj implements Serializable {

    private String navn;
    private String alder;
    private LocalDate foedselsdato;
    private String epost;
    private String telefonnummer;

    public PersonJobj (String navn1, String alder1, LocalDate foedselsdato1, String epost1, String telefonnummer1) throws InputException {

        if (PersonValidator.ValidateNavn(navn1) && PersonValidator.ValidateAlder(alder1) && PersonValidator.ValidateFoedselsdato(foedselsdato1) && PersonValidator.ValidateEpost(epost1) && PersonValidator.ValidateTelefonnummer(telefonnummer1)) {

            this.navn = navn1;
            this.alder = alder1;
            this.foedselsdato = foedselsdato1;
            this.epost = epost1;
            this.telefonnummer = telefonnummer1;
        }
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAlder() {
        return alder;
    }

    public void setAlder(String alder) {
        this.alder = alder;
    }

    public LocalDate getFoedselsdato() {
        return foedselsdato;
    }

    public void setFoedselsdato(LocalDate foedselsdato) {
        this.foedselsdato = foedselsdato;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    @Override
    public String toString() {
        return String.format(navn, alder, foedselsdato, epost, telefonnummer);
    }
}
