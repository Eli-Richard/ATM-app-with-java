public class Deposit extends Transaction{


    private Keypad keypad;
    private DepositSlot depositSlot;
    private static final int CANCEL = 0;

    public Deposit(int accountNumber, Screen screen, BankDatabase database, Keypad keypad, DepositSlot depositSlot){

    super(accountNumber, screen, database);

    this.keypad = keypad;
    this.depositSlot = depositSlot;
    }

    @Override
    public void execute(){
        BankDatabase database = getBankDatabase();
        Screen screen = getScreen();



        screen.displayMessageLn("enter amount to deposit or 0 to cancel");
       double depositAmount = keypad.getIntInput();

       if (depositAmount != CANCEL){

           boolean cashReceived = depositSlot.isEnvelopReceived();

           if(cashReceived){
            database.credit(getAccountNumber(),depositAmount);

            screen.dollarFormat(depositAmount);
            screen.displayMessage(" credited successfully. Deposited amount will be verified and credited to your available balance soon");
           }
           else {
               screen.displayMessageLn("insert envelope");
           }

       }
       else{
           screen.displayMessage("Cancelling.......\n\n");

       }


    }


}
