import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    private String eMail;

    public Person(String name, int age, String eMail) {
        this.name = name;
        this.age = age;
        this.eMail = eMail;
    }

    public Person(String dataString, boolean csv) {
        if (!csv) {
            return;
        }
        String[] data = dataString.split(",");
        this.name = data[0];
        this.age = Integer.parseInt(data[1]);
        this.eMail = data[2];
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", eMail='" + eMail + '\'' +
                '}';
    }

    public String toString(boolean csv) {
        if (!csv) {
            return toString();
        }
        return name + "," + age + "," + eMail;
    }

    public static void main(String[] args) {
        final String FILE_NAME = "..//assets//person.csv";
        Person person = new Person("John Smith", 30, "js123@sussex.ac.uk");
        Person person2 = new Person("Jane Doe", 25, "jd456@sussex.ac.uk");
        System.out.println(person.toString(true));
        ArrayList<String> personList = new ArrayList<>();
        personList.add(person.toString(true));
        personList.add(person2.toString(true));
        FileIO.writeDataToFile(FILE_NAME, personList);
        ArrayList<String> readData = (ArrayList<String>) FileIO.readDataFromFile(FILE_NAME);
        for (String s : readData) {
            System.out.println(new Person(s, true));
        }
    }
}
