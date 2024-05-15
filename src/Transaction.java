public abstract class Transaction {
    private int accountNumber;

    private Screen screen;
    private BankDatabase bankDatabase;

    public Transaction(int accountNumber, Screen screen, BankDatabase database){
        this.accountNumber = accountNumber;
        this.screen = screen;
        this.bankDatabase = database;
    }

    public Screen getScreen(){
        return screen;
    }

    public BankDatabase getBankDatabase(){
        return bankDatabase;
    }

    public int getAccountNumber(){
        return accountNumber;
    }



    public abstract void execute();
}
