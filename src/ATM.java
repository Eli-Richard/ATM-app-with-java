public class ATM {

    private Screen screen;
    private CashDispenser dispenser;
    private BankDatabase database;
    private Keypad keypad;
    private DepositSlot depositSlot;

    private static final int BALANCE_ENQUIRY = 1;
    private static final int DEPOSIT = 2;
    private static final int WITHDRAWAL = 3;
    private static final int EXIT = 4;



    private boolean authenticateUser;

    private int currentUserAccountNumber;

    public ATM(){
        authenticateUser = false;
        currentUserAccountNumber = 0;
        screen = new Screen();
        dispenser = new CashDispenser();
        database = new BankDatabase();
        keypad = new Keypad();
        depositSlot = new DepositSlot();

    }

    public void Run(){
        while(true){
            while(!authenticateUser) {
                screen.displayMessageLn("welcome");
                authenticateUser();
            }

            performTransaction();
            authenticateUser = false;
            currentUserAccountNumber = 0;
            screen.displayMessageLn("goodbye.. Have a nice day");

        }



    }

    public void authenticateUser(){

        screen.displayMessageLn("Enter account number");
        int accountNumber = keypad.getIntInput();
        screen.displayMessageLn("Enter PIN");
        int pin = keypad.getIntInput();

        authenticateUser = database.authenticateUser(accountNumber,pin);

        if(authenticateUser){
            currentUserAccountNumber = accountNumber;
        }
        else {
            screen.displayMessageLn("invalid Pin or Password");
        }


    }

    private int userChoice(){
        screen.displayMessageLn("Main manu");
        screen.displayMessageLn("1 - Balance Enquiry");
        screen.displayMessageLn("2 - Deposit");
        screen.displayMessageLn("3 - Withdraw");
        screen.displayMessageLn("4 - Exit");

        screen.displayMessageLn("");
        screen.displayMessageLn("what transaction do you want to perform");
        int choice = keypad.getIntInput();

        return choice;
    }

    private Transaction createTransaction(int type){

        Transaction transactionType = null;

        if(type == 1){
            transactionType = new BalanceEnquiry(currentUserAccountNumber, screen,database);
        }
        else if (type == 2) {
            transactionType = new Deposit(currentUserAccountNumber,screen,database,keypad, depositSlot);

        }
        else if (type == 3) {
            transactionType = new Withdrawal(currentUserAccountNumber,screen,database,keypad,dispenser);
        }

        else if (type == 4){
            screen.displayMessageLn("exiting");
        }

        return transactionType;
    }

    public void performTransaction(){
Transaction currentTransaction = null;
        boolean userExited = false;

        while (!userExited){
            int choice = userChoice();
            switch (choice){
                case BALANCE_ENQUIRY,DEPOSIT,WITHDRAWAL:
                   currentTransaction = createTransaction(choice);
                   currentTransaction.execute();
                 break;

                case EXIT:
                    screen.displayMessageLn("Exiting system");
                    userExited = true;

            }


        }

    }




}