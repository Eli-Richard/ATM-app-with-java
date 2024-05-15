public class BalanceEnquiry extends Transaction {

    public BalanceEnquiry(int accountNumber, Screen screen, BankDatabase database){
         super(accountNumber, screen, database);
    }
@Override
    public void execute(){
        Screen screen = getScreen();
        BankDatabase database = getBankDatabase();

        double availableBalance = database.getAvailableBalance(getAccountNumber());
        double totalBalance = database.getTotalBalance(getAccountNumber());

        screen.displayMessageLn("Account Balance");
        screen.displayMessage("Available Balance:");
        screen.dollarFormat(availableBalance);
        screen.displayMessage("Available Balance:");
        screen.dollarFormat(totalBalance);
        screen.displayMessageLn("");

}

}
