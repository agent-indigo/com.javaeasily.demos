import java.text.DecimalFormat;
import java.text.NumberFormat;

public class App {
    public static void main(String[] args){
        System.out.println("Loan Calculator".toUpperCase());
        System.out.println();
        double amount = 1000;
        int years = 5;
        double interestRate = 1.5;
        try {
            printInputs(amount, years, interestRate);
            printResult(new LoanCalculator(amount, years, interestRate).calculateRepaymentAmount(amount, years, interestRate));
        } catch (LoanCalculationException error) {
            System.out.println(error.getMessage());
        }
    }
    private static void printResult(double currentAmountPayable) {
        NumberFormat formatter = new DecimalFormat("#0.00");
        System.out.println("Total amount due: $" + formatter.format(currentAmountPayable));
    }
    private static void printInputs(double amount, int years, double interestRate) {
        System.out.println("Calculating loan based on:");
        System.out.println("Initial amount:   $" + amount);
        System.out.println("Number of Years:   " + years);
        System.out.println("Interest Rate:     " + interestRate + "%");
    }
}