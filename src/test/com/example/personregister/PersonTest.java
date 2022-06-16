package com.example.personregister;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testValidNavn() {
        assertDoesNotThrow( () -> PersonValidator.ValidateNavn("Ola Nordmann"));
    }

    @Test
    void testInvalidNavn() {
        assertThrows(InputException.class, () -> PersonValidator.ValidateNavn(""));
        assertThrows(InputException.class, () -> PersonValidator.ValidateNavn("=?#"));
        assertThrows(InputException.class, () -> PersonValidator.ValidateNavn("ola nordmann"));
        assertThrows(InputException.class, () -> PersonValidator.ValidateNavn("OlaNordmann"));
    }

    @Test
    void testValidAlder() {
        assertDoesNotThrow( () -> PersonValidator.ValidateAlder("22"));
    }

    @Test
    void testInvalidAlder() {
        assertThrows(InvalidAgeException.class, () -> PersonValidator.ValidateAlder("0"));
        assertThrows(InvalidAgeException.class, () -> PersonValidator.ValidateAlder("200"));
    }

    LocalDate date = LocalDate.of(1901, 1, 1);
    LocalDate date2 = LocalDate.of(2022, 1, 1);

    @Test
    void testValidFoedselsdato() {
        assertDoesNotThrow( () -> PersonValidator.ValidateFoedselsdato(date));
        assertDoesNotThrow( () -> PersonValidator.ValidateFoedselsdato(date2));
    }

    LocalDate date3 = LocalDate.of(1899, 1, 1);

    LocalDate date4 = LocalDate.of(2023, 1, 1);

    @Test
    void testInvalidFoedselsdato() {
        assertThrows(InvalidDateException.class, () -> PersonValidator.ValidateFoedselsdato(date3));
        assertThrows(InvalidDateException.class, () -> PersonValidator.ValidateFoedselsdato(date4));
    }

    @Test
    void testvalidEpost() {
        assertDoesNotThrow( () -> PersonValidator.ValidateEpost("ola.nordmann@outlook.com"));
        assertDoesNotThrow( () -> PersonValidator.ValidateEpost("example@example.com"));
        assertDoesNotThrow( () -> PersonValidator.ValidateEpost("uk.domain@co.uk"));
    }

    @Test
    void testInvalidEpost() {
        assertThrows(InputException.class, () -> PersonValidator.ValidateEpost("ola.nordmann"));
        assertThrows(InputException.class, () -> PersonValidator.ValidateEpost("@outlook.com"));
        assertThrows(InputException.class, () -> PersonValidator.ValidateEpost("test@"));
    }

    @Test
    void testValidTelefonnummer() {
        assertDoesNotThrow( () -> PersonValidator.ValidateTelefonnummer("55551234"));
        assertDoesNotThrow( () -> PersonValidator.ValidateTelefonnummer("+4755551234"));
        assertDoesNotThrow( () -> PersonValidator.ValidateTelefonnummer("004755551234"));
    }

    @Test
    void testInvalidTelefonnummer() {
        assertThrows(InputException.class, () -> PersonValidator.ValidateTelefonnummer("Not a number"));
        assertThrows(InputException.class, () -> PersonValidator.ValidateTelefonnummer("-231"));
        assertThrows(InputException.class, () -> PersonValidator.ValidateTelefonnummer("123 123     123 12"));
    }
}