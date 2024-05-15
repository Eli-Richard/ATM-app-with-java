public class Screen {
    public void displayMessage(String message){
        System.out.print(message);
    }

    public void displayMessageLn(String message){
        System.out.println(message);
    }

    public void dollarFormat(double amount){
        System.out.printf("$%,.2f", amount);
    }

}
