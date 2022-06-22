package com.example.personregister;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public interface FileSaver {

}

class FileSaverTxt implements FileSaver {

    public void save(List<?> objects, Path file) throws IOException {
        Files.write(file, objects.toString().getBytes());
    }
}

class FileSaverJobj implements FileSaver {

    public void saveJobj(ArrayList<PersonJobj> personer, File file) {

        try (OutputStream os = new FileOutputStream(file);
             ObjectOutputStream out = new ObjectOutputStream(os)) {

            out.writeObject(personer);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
