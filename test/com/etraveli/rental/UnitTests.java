package com.etraveli.rental;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class UnitTests {

    protected String readFile(String path) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get(path)));
        return contents;
    }
}