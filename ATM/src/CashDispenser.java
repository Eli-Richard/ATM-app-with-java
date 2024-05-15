public class CashDispenser {

    private final static int INITIAL_STOCK = 500;
    private int count;

    public CashDispenser(){
        count = INITIAL_STOCK;
    }

    public void dispenseMoney(double amount){
        int availableBill = (int) (amount/20);
         count = count - availableBill;

    }

    public boolean isCashAvailable(double amount){
        int availableBill = (int) amount/20;

        if (availableBill< count){
            return true;
        }
        else {
            return false;
        }


    }
}
