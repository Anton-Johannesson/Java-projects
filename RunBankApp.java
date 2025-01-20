import java.util.Scanner;

public class RunBankApp {
    public static void main(String[] args) {
        Bank bank = new Bank();
        //RunUI.textMenu();
        RunUI.RunApp(new Scanner(System.in), bank);
        }
    
}
