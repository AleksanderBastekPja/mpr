public class Person {
    public Integer age;
    public String name;

    public Person(int age, String name) throws InvalidAgeException {
        if (age < 0) throw new InvalidAgeException("Wiek jest na minus");
        this.age = age;
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
