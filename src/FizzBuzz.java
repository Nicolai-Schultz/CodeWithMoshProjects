import java.util.Locale;
import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Number:");
        int input = scanner.nextInt();
        boolean conditionBuzz = (input % 3 == 0);
        boolean conditionFizz = (input % 5 == 0);

        if (conditionFizz && conditionBuzz) {
            System.out.println("Fizzbuzz");
        } else if (conditionFizz) {
            System.out.println("Fizz");
        } else if (conditionBuzz) {
            System.out.println("Buzz");
        } else {
            System.out.println(input);
        }


    }
}