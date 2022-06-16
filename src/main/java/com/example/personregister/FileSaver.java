package com.example.personregister;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public interface FileSaver {

}

class FileSaverTxt implements FileSaver {

    public void save(List<?> objects, Path file) throws IOException {
        Files.write(file, objects.toString().getBytes());
    }
}
