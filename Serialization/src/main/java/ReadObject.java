import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {
    public void read(String file) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Person person;

        while ((fis.available())>0) {
            person = (Person) ois.readObject();
            setActiv(person);
            toString(person);
        }
        fis.close();
        ois.close();
    }

    public void setActiv(Person person){
        if (person.getAge() < 3) {
            person.setActivity(Activity.HOME);
        }
        if (person.getAge() >= 3 & person.getAge() < 7) {
            person.setActivity(Activity.KINDERGARTEN);
        }
        if (person.getAge() >= 7 & person.getAge() < 17) {
            person.setActivity(Activity.SCHOOL);
        }
        if (person.getAge() >= 17 & person.getAge() < 23) {
            person.setActivity(Activity.INSTITUTE);
        }
        if (person.getAge() >= 23 & person.getAge() < 65) {
            person.setActivity(Activity.WORK);
        }
        if (person.getAge() >= 65) {
            person.setActivity(Activity.PENSION);
        }
    }

    public void toString(Person person) {
        System.out.println(person.getName() + " " + person.getAge() + " " + person.getActivity());
    }
}