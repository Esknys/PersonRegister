package com.example.personregister;

import java.time.LocalDate;

public class PersonValidator {

    public static boolean ValidateNavn(String navn) throws InputException {
        if (navn.matches("[A-ZÆØÅ][a-zæøå]* [A-ZÆØÅ][a-zæøå]*")) {
            return true;
        }
        throw new InputException("Invalid name");
    }

    public static boolean ValidateAlder(String alder) throws InvalidAgeException {
        int alder2 = Integer.valueOf(alder);
        if (!(alder2 > 0) || !(alder2 <= 122)) {
            throw new InvalidAgeException("Invalid age");
        }
        return true;
    }

    public static boolean ValidateFoedselsdato(LocalDate foedselsdato) throws InvalidDateException {
        int year = Integer.valueOf(foedselsdato.getYear());
        if (!(year >= 1900) || !(year <= 2022)) {
            throw new InvalidDateException("Invalid date");
        }
        return true;
    }

    public static boolean ValidateEpost(String epost) throws InputException {
        if (epost.matches("^(.+)@(.+)$")) {
            return true;
        }
        throw new InputException("Invalid e-mail");
    }

    public static boolean ValidateTelefonnummer(String telefonnummer) throws InputException {
        if (telefonnummer.matches("(0047|\\+47|47)?\\d{8}")) {
            return true;
        }
        throw new InputException("Invalid number");
    }
}
