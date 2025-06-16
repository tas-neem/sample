public class CrossFileMain {
    public static void main(String[] args) {
        try {
            Person person = new Person(25); 
            System.out.println("Person created with age: " + person.getAge());

            Person invalidPerson = new Person(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class Person {
    private int age;

    public Person(int age) {
        this.age = CrossFileUtils.validateAge(age);
    }

    public int getAge() {
        return age;
    }
}
