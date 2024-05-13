import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides utility methods for file operations.
 */
public class FileIO {

    /**
     * Writes a list of strings to a file, each string on a new line.
     *
     * @param fileName The name of the file to write to.
     * @param userData The list of strings to write to the file.
     */
    public static void writeDataToFile(String fileName, List<String> userData) {
        try {
            // Path is used here to create directories if they don't exist
            // converts the string to a Path object
            Path filePath = Path.of(fileName);
            // createDirectories() creates all directories in the path if they don't exist
            System.out.println("Parent is " + filePath.getParent());
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, userData);
            System.out.println("Data saved to " + filePath);
        } catch (IOException e) {
            System.out.println(fileName + " cannot be written to");
        }
    }

    /**
     * Reads a file and returns its contents as a list of strings.
     *
     * @param fileName The name of the file to read from.
     * @return A list of strings containing the lines of the file.
     */
    public static List<String> readDataFromFile(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            System.out.println(fileName + " file can't be read. Error " + e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * Writes a list of strings to a file using serialization.
     *
     * @param fileName The name of the file to write to.
     * @param userData The list of strings to write to the file.
     */
    public static void writeSerialDataToFile(String fileName, List<String> userData) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            Path filePath = Path.of(fileName);
            Files.createDirectories(filePath.getParent());
            oos.writeObject(userData);
            System.out.println("Data saved to " + Path.of(fileName));
        } catch (IOException e) {
            System.out.println(fileName + " cannot be written to");
        }
    }

    /**
     * Reads a file and returns its contents as a list of strings using deserialization.
     *
     * @param fileName The name of the file to read from.
     * @return A list of strings containing the lines of the file.
     */
    public static List<String>  readSerialDataFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(fileName + " file can't be read. Error " + e.getMessage());
            return new ArrayList<>();
        }
    }
}