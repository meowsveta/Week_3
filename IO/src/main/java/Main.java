import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Developer dev1 = new Developer("Наташа", Arrays.asList("Java", "C++"));
        Developer dev2 = new Developer("Эрнест", Arrays.asList("Java", "Python"));
        Developer dev3 = new Developer("Элла", Arrays.asList("С#", "Python", "JavaScript"));

        List<Developer> team = Arrays.asList(dev1, dev2, dev3);

        Map<String, Integer> count = team.stream()
                .flatMap(developer -> developer.getLanguages().stream())
                .collect(Collectors.toMap(
                        language -> language,
                        language -> 1,
                        Integer::sum
                ));

        List<Developer> uniqueDevs = team.stream().filter(developer -> developer.getLanguages().stream()
                .anyMatch(lang -> count.get(lang) == 1)).toList();


        StringJoiner sj = new StringJoiner(", ");
        uniqueDevs.forEach(developer -> sj.add(developer.getName()));
        System.out.println(sj);


    }
}

