import java.text.NumberFormat;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // initializing number format method
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        double interestRate = scanner.nextDouble();
        double interestRateConverted = (interestRate / 100) / 12;

        System.out.print("Period (Years): ");
        int period = scanner.nextInt();
        int periodConverted = period * 12;

        double mortgageCalculation = principal * (interestRateConverted * Math.pow((1 + interestRateConverted), periodConverted)) / (Math.pow((1 + interestRateConverted), periodConverted) - 1);
        String resultOfMortgageCalculationInUsd = currency.format(mortgageCalculation);
        // Concatenate the calculation as well..
        System.out.print("Mortgage: " + resultOfMortgageCalculationInUsd);


    }
}
