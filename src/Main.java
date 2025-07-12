import java.text.NumberFormat;
import java.util.Scanner;
import java.util.Locale;

// Mortgage calculator class
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

        // implementing do-while for error handling
        int principal = 0;
        do{
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if(!(1000 <= principal && principal <= 1_000_000)){
                System.out.print("Enter a number between 1000 and 1_000_000." + "\n");
            }
        } while(!(1000 <= principal && principal <= 1_000_000));

        double interestRate = 0;
        do{
            System.out.print("Annual Interest Rate: ");
            interestRate = scanner.nextDouble();
            if(!(0 < interestRate && interestRate <= 30)){
                System.out.print("Enter a number between 0 and 30." + "\n");
            }
        } while(!(0 < interestRate && interestRate <= 30));

        int period = 0;
        do{
            System.out.print("Period (Years): ");
            period = scanner.nextInt();
            if(!(0 < period && period <= 30)){
                System.out.print("Enter a number between 0 and 30." + "\n");
            }
        } while(!(0 < period && period <= 30));


        MortgageCalculator calculator = new MortgageCalculator(principal, interestRate, period);
        double mortgageCalculation = calculator.calculateMonthlyPayment();
        String resultOfMortgageCalculationInUsd = currency.format(mortgageCalculation);

        System.out.print("Mortgage: " + resultOfMortgageCalculationInUsd);
    }
}
