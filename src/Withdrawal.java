

public class Withdrawal extends Transaction{
private Keypad keypad;
private CashDispenser dispenser;
private final static int  CANCEL = 6;

    public  Withdrawal (int accountNumber, Screen screen, BankDatabase database, Keypad keypad, CashDispenser dispenser){
        super(accountNumber, screen, database );

        this.dispenser = dispenser;
        this.keypad = keypad;


    }

    public int basicWithdrawableAmount(){

        int[] basicAmount = {0,20,40,60,100,200};
        int userChoise = 0;


        while (userChoise == 0){
            Screen screen =getScreen();
            screen.displayMessageLn("enter amount to withdraw:\n");

            screen.displayMessageLn("1 - 20");
            screen.displayMessageLn("2 - 40");
            screen.displayMessageLn("3 - 60");
            screen.displayMessageLn("4 - 100");
            screen.displayMessageLn("5 - 200\n");
            screen.displayMessageLn("Press 6 to CANCEL");

            int input = keypad.getIntInput();


            switch (input){
                case 1, 2,3,4,5:
                    userChoise  = basicAmount[input];
                    break;

                case 6:
                    userChoise = 6;
            }


        }

        return userChoise;
    }


    @Override
    public void execute(){
        boolean cashDispensed = false;
        BankDatabase database = getBankDatabase();
        Screen screen = getScreen();

        int choice = basicWithdrawableAmount();

        if (choice != CANCEL){
        do{
            if( choice < database.getAvailableBalance(getAccountNumber()) ){
                 if(dispenser.isCashAvailable(choice)){
                    database.debit(getAccountNumber(),choice);
                    dispenser.dispenseMoney(choice);
                    cashDispensed = true;
                 }
                 else{
                     screen.displayMessageLn("not enough funds in ATM currently. Choose smaller amount");
                 }

            }
            else {
                screen.displayMessageLn("Not Enough Funds. Try again");
            }


        }
        while (!cashDispensed);



    }
        else {
            screen.displayMessageLn("Canceling transaction.....\n");
        }
}}
