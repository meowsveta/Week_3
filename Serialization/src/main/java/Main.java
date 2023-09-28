import java.io.*;
import java.util.ArrayList;

public class Main {
    static String file = "/Users/svetlanaklimova/Desktop/Week_3/Serialization/src/main/java/test.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ReadObject readObject = new ReadObject();

        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Анна", 10, Activity.SCHOOL));
        list.add(new Person("Андрей", 22, Activity.INSTITUTE));
        list.add(new Person("Екатерина", 3, Activity.KINDERGARTEN));
        list.add(new Person("Михаил", 30, Activity.WORK));
        list.add(new Person("Дмитрий", 70, Activity.PENSION));
        list.add(new Person("Мария", 2, Activity.HOME));


        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);

        for (Person person : list) {
            oos.writeObject(person);
        }

        readObject.read(file);

        fileOutputStream.close();
        oos.close();
    }
}
