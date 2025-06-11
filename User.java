public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        if (age < 0) throw new IllegalArgumentException("Age must be non-negative");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
