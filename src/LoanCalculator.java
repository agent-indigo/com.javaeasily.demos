public class LoanCalculator {
    private double amount;
    private int years;
    private double interestRate;
    public LoanCalculator(double amount, int years, double interestRate) throws LoanCalculationException {
        if (amount <= 0 || years <= 0 || interestRate <= 0) {
            throw new LoanCalculationException("Cannot calculate repayment amount: invalid values.");
        }
        this.amount = amount;
        this.years = years;
        this.interestRate = interestRate;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public int getYears() {
        return years;
    }
    public void setYears(int years) {
        this.years = years;
    }
    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    public double calculateRepaymentAmount(double amount, int years, double interestRate) {
        double interestRateMultiplier = 1 + interestRate / 100;
        double currentAmountPayable = amount;
        int currentYear = 1;
        while (currentYear <= years) {
            currentAmountPayable = currentAmountPayable * interestRateMultiplier;
            currentYear ++;
        }
        return currentAmountPayable;
    }
}