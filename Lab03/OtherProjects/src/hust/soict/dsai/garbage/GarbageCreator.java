package hust.soict.dsai.garbage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
	public static void main(String[] args) {
        String filename = "test.exe";

        try {
            if (!Files.exists(Paths.get(filename))) {
                createLargeFile(filename);
            }

            System.out.println("Starting to read file with String concatenation...");
            long startTime = System.currentTimeMillis();

            try (FileReader fr = new FileReader(filename)) {
                String content = "";
                int character;
                int charCount = 0;

                while ((character = fr.read()) != -1) {
                    content += (char) character;  
                    charCount++;

                    if (charCount % 1000000 == 0) {
                        System.out.println("Read " + charCount + " characters...");
                    }
                }

                System.out.println("Final string length: " + content.length());
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Time taken: " + (endTime - startTime) + " ms");

        } catch (OutOfMemoryError e) {
            System.out.println("Out of Memory Error occurred!");
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO Error occurred!");
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createLargeFile(String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (int i = 0; i < 100000000; i++) {
                writer.write("This is a test line to create a large file.\n");
            }
        }
    }
}
