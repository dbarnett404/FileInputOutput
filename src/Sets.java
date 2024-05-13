import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * The Sets class provides methods for working with sets of elements.
 */
public class Sets {

    /**
     * Generates a list of random numbers.
     *
     * @param length  the length of the list
     * @param maxNum  the maximum value for the random numbers
     * @return        an ArrayList containing the random numbers
     */
    public static ArrayList<Integer> getRandomNumList(int length, int maxNum) {
        Set<Integer> numbers = new HashSet<>();
        // Use the unique properties of sets to generate a set of random numbers
        while (numbers.size() < length) {
            int num = (int) (Math.random() * maxNum);
            numbers.add(num);
        }
        return new ArrayList<>(numbers);
    }
    
    /**
     * The main method of the Sets class.
     *
     * @param args  the command-line arguments
     */
    public static void main(String[] args) {
        // Create a set of strings
        Set<String> setA = new HashSet<>();
        Set<String> setB = new HashSet<>();
        for (String s : AnimalNames.NAMES_01) {
            setA.add(s);
        }
        
        for (String s : AnimalNames.NAMES_02) {
            setB.add(s);
        }

        // Print the set
        System.out.println("Set 1: " + setA);
        System.out.println("Set 2: " + setB);
        // Create a copy of set
        Set<String> intersection = new HashSet<>(setA);

        // Retain only elements in set2
        intersection.retainAll(setB);
        System.out.println("Intersection: " + intersection);
        
        Set<String> unionSet = new HashSet<>(setA);
        unionSet.addAll(setB);
        System.out.println("Union: " + intersection);

        Set<String> differenceSet = new HashSet<>(setA);
        differenceSet.removeAll(setB);
        System.out.println("Difference: " + differenceSet);

        // Create a set of integers
        ArrayList<Integer> numbers = getRandomNumList(10, 100);
        
        // Print the set
        System.out.println("Numbers: " + numbers);
    }
}
