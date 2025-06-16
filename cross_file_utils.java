public class CrossFileUtils {
    public static int validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        return age;
    }
}
