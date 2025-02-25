package com.thentrees;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Executors;

public class VirtualThreadFileReader {
    public static void main(String[] args) {
        var executor = Executors.newVirtualThreadPerTaskExecutor();

        for (int i = 1; i <= 10; i++) {
            int fileNumber = i;
            executor.submit(() -> {
                try {
                    String content = Files.readString(Path.of("file" + fileNumber + ".txt"));
                    System.out.println("Content of file" + fileNumber + ": " + content);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }
}