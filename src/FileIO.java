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
     * @param fileName The name of the file to write to and optionally the file path.
     * @param userData The list of strings to write to the file.
     */
    public static void writeDataToFile(String fileName, List<String> userData) {
        try {
            // Path is used here to create directories if they don't exist
            // converts the string to a Path object
            Path filePath = Path.of(fileName);
            // createDirectories() creates all directories in the path if they don't exist
            Files.createDirectories(filePath.getParent());
            // write the list of strings to the file
            Files.write(filePath, userData);            
        } catch (IOException e) {
            // print a relevant error message if the file cannot be written to
            System.out.println(fileName + " cannot be written to " + e.getMessage());
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
    public static List<String> readSerialDataFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<String> userData = (List<String>) ois.readObject();
            return userData;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(fileName + " file can't be read. Error " + e.getMessage());
            return new ArrayList<>();
        }
    }
}