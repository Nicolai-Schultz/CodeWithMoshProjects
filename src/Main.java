import java.text.NumberFormat;
import java.util.Scanner;
import java.util.Locale;



public class Main {
    public static void main(String[] args) {

        int principal = (int) readNumber("Principal", 1000, 1000000);
        float annualInterest = (float) readNumber("Annual interest rate", 1, 30);
        byte years = (byte) readNumber("Period (years)", 1, 30);

        double mortgageCalculation = calculateMortgage(principal, annualInterest, years);
        String resultOfMortgageCalculationInUsd = outputInCurrency(mortgageCalculation);

        outputInCorrectFormat(resultOfMortgageCalculationInUsd, principal, annualInterest, years);
    }

    public static String outputInCurrency(double input){
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
        return currency.format(input);
    }

    public static void outputInCorrectFormat(String monthlyPayment,
                                             int principal,
                                             float annualInterest,
                                             byte years){
        // monthly payment output
        System.out.print("""
        MORTGAGE
        --------
        Monthly Payment:""" + " " + monthlyPayment);

        // payment schedule output
        System.out.print("""
                
                PAYMENT SCHEDULE
                --------
                """);
        printPayments(principal, annualInterest, years);
    }

    public static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double value;
        while (true) {
            System.out.print(prompt + ": ");
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.print("Enter a number between" + min + " and " + max + "\n");
        }
        return value;
    }

    public static double calculateMortgage(int principal,
                                           float annualInterest,
                                           byte years) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);
        float monthlyInterest = annualInterest / PERCENT / 12;
        double mortgageCalculation = principal *
                (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) /
                (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgageCalculation;
    }

    public static double calculatePayments(int principal,
                                           float annualInterest,
                                           byte years,
                                           int numberOfPaymentsMade){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterest = annualInterest / PERCENT / 12;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);
        // Number of payments made is always 1 at the start

        double payments = (principal *
                ( Math.pow((1 + monthlyInterest),numberOfPayments) -
                        Math.pow((1 + monthlyInterest),numberOfPaymentsMade))) /
                (Math.pow((1 + monthlyInterest),numberOfPayments) - 1);

        return payments;
    }

    public static void printPayments(int principal,
                                     float annualInterest,
                                     byte years){
        int numberOfPaymentsMade = 1;
        double payments = 1;

        while(payments != 0){
            payments = calculatePayments(principal, annualInterest, years, numberOfPaymentsMade);
            // print payment
            System.out.print(outputInCurrency(payments) + "\n");

            // iterate number of payments made
            numberOfPaymentsMade++;
        }
    }
}
