public class greetUser {
    public static void main(String[] args) {
        String message = greetUserClass("Nicolai", "Lomps");
        System.out.println(message);
    }

    // Public means that the method can be called outside the class
    // It is important to note that this is ONLY a method (function), and not a class.
    public static String greetUserClass(String firstName, String lastName) {
        return "Hello " + firstName + " " + lastName;
    }
}

