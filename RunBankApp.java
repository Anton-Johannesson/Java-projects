import java.util.Scanner;

public class RunBankApp {
    public static void main(String[] args) {
        Bank bank = new Bank();
        //SimpleWindow sw = new SimpleWindow(1000, 1000, "Banken");
        //RunUI.textMenu();


        //DENNA FUNKAR
        RunUI.RunApp(new Scanner(System.in), bank);
        }
    
}
