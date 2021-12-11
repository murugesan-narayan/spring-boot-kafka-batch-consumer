package com.muru.kafka.consumer.demo;

import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class TestDataCreatorUtils {
    @Test
    public void createTestFile_1mb() throws IOException {
        createFile(1);
    }

    @Test
    public void createTestFile_2mb() throws IOException {
        createFile(2);
    }

    private void createFile(int mb) throws IOException {
        String fileNameFullPath = "target/test-data-"+mb+"mb.txt";
        Files.deleteIfExists(Path.of(fileNameFullPath));
        Path file = Files.createFile(Path.of(fileNameFullPath));

        List<String> data = new ArrayList<>();
        for (int i = 0; i < 1020 * mb; i++) {
            data.add(i +"-"+ RandomString.make(1000));
        }
        Files.write(file, data, StandardCharsets.UTF_8);
    }

}
