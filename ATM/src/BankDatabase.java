public class BankDatabase {
    private Account[] account;

    public BankDatabase(){
        account = new Account[2];

        account[0] = new Account(123456789, 2468, 345, 345);
        account[1] = new Account(987654321, 1234, 20, 20);

    }

    public Account getAccount(int accountNumber){
        for (Account currentAccount : account){

            if(currentAccount.getAccountNumber() == accountNumber){
                return currentAccount;

            }
        }

        return null;
    }

    public boolean authenticateUser(int accountNumber, int pin){

        Account eli = getAccount(accountNumber);
        if (eli !=null){
           return eli.validatePin(pin);

        }
        else{
            return false;
        }

    }

    public double getTotalBalance(int accountNumber){

            return getAccount(accountNumber).getTotalBalance();
    }

    public double getAvailableBalance(int accountNumber){
        return getAccount(accountNumber).getAvailableBalance();
    }

    public void credit(int accountNumber, double amount){
        getAccount(accountNumber).creditAccount(amount);

    }

    public void debit(int accountNumber, double amount){
        getAccount(accountNumber).debitAccount(amount);
    }



}
