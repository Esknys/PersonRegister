package com.example.personregister;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface FileOpener {

}

class FileOpenerTxt implements FileOpener {

    public List<Person> read(String path) throws IOException, InputException {
        ArrayList<Person> list = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            String line;

            while((line = reader.readLine()) != null) {
                list.add(parsePerson(line));
            }
        }
        return list;
    }

    private Person parsePerson(String line) throws InvalidPersonFormatException, InputException {
        String [] array = line.split(";");
        if(array.length != 5) {
            throw new InvalidPersonFormatException("Must use semicolon ; to separate the five data fields.");
        }

        String name = array[0];
        String age = array[1];
        LocalDate date = LocalDate.parse(array[2]);
        String email = array[3];
        String telefonnummer = array[4];

        return new Person(name, age, date, email, telefonnummer);
    }
}
