import java.util.ArrayList;
import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final String FILE_NAME = "..//assets//animals.txt";
    private static final String SERIAL_FILE_NAME = "...//assets//animals.ser";
    public static void main(String[] args) {
        //Convert the array of names to an ArrayList
        ArrayList<String> animalNames1 = new ArrayList<>(Arrays.asList(AnimalNames.NAMES_01));
        FileIO.writeDataToFile(FILE_NAME, animalNames1);
        ArrayList<String> animalNames2 = (ArrayList<String>) FileIO.readDataFromFile(FILE_NAME);
        System.out.println("Reading from file: ");
        for (String name : animalNames2) {
            System.out.println(name);
        }
        FileIO.writeSerialDataToFile(SERIAL_FILE_NAME, animalNames1);
        animalNames2 = new ArrayList<>(FileIO.readSerialDataFromFile(SERIAL_FILE_NAME));
        System.out.println("Reading from serial file: ");
        for (String name : animalNames2) {
            System.out.println(name);
        }
    }
}

