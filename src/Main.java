import java.text.NumberFormat;
import java.util.Scanner;
import java.util.Locale;

class MortgageCalculator {
    private final int principal;
    private final double annualInterest;
    private final int years;

    public MortgageCalculator(int principal, double annualInterest, int years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateMonthlyPayment() {
        double monthlyInterest = annualInterest / 100 / 12;
        int numberOfPayments = years * 12;

        return principal *
                (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) /
                (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }
}

public class Main {
    public static void main(String[] args) {
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        double interestRate = scanner.nextDouble();

        System.out.print("Period (Years): ");
        int period = scanner.nextInt();

        MortgageCalculator calculator = new MortgageCalculator(principal, interestRate, period);
        double mortgageCalculation = calculator.calculateMonthlyPayment();
        String resultOfMortgageCalculationInUsd = currency.format(mortgageCalculation);

        System.out.print("Mortgage: " + resultOfMortgageCalculationInUsd);
    }
}
