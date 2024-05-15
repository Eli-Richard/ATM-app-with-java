public class Account {

    private int accountNumber;
    private int pin;
    private double totalBalance;
    private double availableBalance;

    public Account(int accountNumber, int pin, double totalBalance, double availableBalance){
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.totalBalance = totalBalance;
        this.availableBalance = availableBalance;
    }

    public double getTotalBalance(){
        return totalBalance;
    }

    public double getAvailableBalance(){
        return availableBalance;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public boolean validatePin(int pin){
        if (pin == this.pin){
            return true;
        }
        else {
            return false;
        }
    }

    public void creditAccount(double amount){
        totalBalance += amount;
        //availableBalance += amount;  // bank validates available balance at a later time.
    }

    public void debitAccount(double amount){
        totalBalance -= amount;
        availableBalance -= amount;
    }
}
