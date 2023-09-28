import java.util.*;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8

            try {
                Person person1 = new Person(1, "a");
                System.out.println(person1.toString());
            } catch (InvalidAgeException e) {
                throw new RuntimeException(e);
            }
            try {
                Person person2 = new Person(2, "b");
                System.out.println(person2.toString());
            } catch (InvalidAgeException e) {
                throw new RuntimeException(e);
            }
            try {
                Person person3 = new Person(3, "c");
                System.out.println(person3.toString());
            } catch (InvalidAgeException e) {
                throw new RuntimeException(e);
            }

            Person person4 = new Person(19,"Jakub");
            Person person5 = new Person(26,"Mateusz");
            Person person6 = new Person(30,"Aleksander");

            List<Person> immutablepersonList = List.of(person4, person5, person6);
            List<Person> mutablePersonList = new ArrayList<>();
            mutablePersonList.add(person4);
            mutablePersonList.add(person5);
            mutablePersonList.add(person6);

            System.out.println("Lista niemutowalna: " + mutablePersonList);
            System.out.println("Lista mutowalna: " + mutablePersonList);

            Set<Person> immutablePersonSet = Set.of(person4, person5, person6);
            Set<Person> mutablePersonSet = new HashSet<>();

            mutablePersonSet.add(person4);
            mutablePersonSet.add(person5);
            mutablePersonSet.add(person6);

            System.out.println("Set niemutowalny: " + immutablePersonSet);
            System.out.println("Set mutowalny: " + mutablePersonSet);

            Map<String, Person> immutablePersonMap = Map.of(
                    "person4", person4,
                    "person5", person5,
                    "person6", person6
            );

            Map<String, Person> mutablePersonMap = new HashMap<>();

            mutablePersonMap.put("person4", person4);
            mutablePersonMap.put("person5", person5);
            mutablePersonMap.put("person6", person6);

            System.out.println("niemutowalna mapa: " + immutablePersonMap);
            System.out.println("mutowalna mapa: " + mutablePersonMap);

            Integer sumAge = immutablepersonList.stream()
                    .map(Person::getAge)
                    .reduce(0, (sum, value) -> sum + value);

            System.out.println("sumAge: " + sumAge);

            List<String> nameList = immutablepersonList.stream()
                    .map(Person::getName)
                    .collect(Collectors.toList());

            System.out.println("nameList: " + nameList);

            List<Person> lowerThanTwenty = immutablepersonList.stream().filter(
                    person -> person.getAge() > 25
            ).collect(Collectors.toList());

            System.out.println("lowerThanTwenty: " + lowerThanTwenty);

            List<Person> alfSortedPersonList =  immutablepersonList.stream()
                    .sorted(Comparator.comparing(Person::getName))
                    .collect(Collectors.toList());

            System.out.println("alfSortedPersonList: " + alfSortedPersonList);

            mutablePersonList.forEach(person -> {
                        System.out.println("name: "+ person.getName());
                System.out.println("age: " + person.getAge());
            });

            Optional<Person> lowestAgePerson = immutablepersonList.stream().min(Comparator.comparing(Person::getAge));
            Optional<Person> highestAgePerson = immutablepersonList.stream().max(Comparator.comparing(Person::getAge));

            System.out.println("lowest age person: " + lowestAgePerson);
            System.out.println("highest age person: " + highestAgePerson);

        }
    }
}