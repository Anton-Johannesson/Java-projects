import java.util.ArrayList;
import java.util.Scanner;
public class RunUI {
    static Scanner scan = new Scanner(System.in);
    
        public static void RunApp(Scanner scan, Bank bank){
            while(true){
                textMenu();
            
            switch(scan.next()){

                case "1":

                scan.nextLine();
                System.out.println("Namn: " + ("\n"));
                String name = scan.nextLine();
                System.out.println("ID: " + ("\n"));
                long id = scan.nextLong();
                int accountNumber = bank.addAcount(name, id);
                System.out.println("Konto skapat, här är kontonummret: " + accountNumber + ("\n"));

                    break;

                case "2":

                scan.nextLine();
                System.out.println("Ange kontonummer som ska tas bort" + ("\n"));
                int accountNumber1 = scan.nextInt();
                if(bank.findByNumber(accountNumber1) == null){
                    System.out.println("Felaktigt kontonummer" + ("\n"));
                }else{
                    bank.removeAccount(accountNumber1);
                    System.out.println("Konton är nu borttaget " + ("\n"));
                }

                    break;

                case "3":

                scan.nextLine();
                System.out.println("Vilket konto vill du sätta in pengar på? " + ("\n"));
                int accountNumber2 = scan.nextInt();
                System.out.println("Ange vilket belopp " + ("\n"));
                double amout = scan.nextDouble();

                bank.findByNumber(accountNumber2).deposit(amout);
                System.out.println(" Du har lagt in såhär mycket pengar: " + 
                        bank.findByNumber(accountNumber2) + "kr" + ("\n"));

                    break;

                case "4":

                scan.nextLine();
                System.out.println("Vilket konto vill du ta ut pengar från? " + ("\n"));
                int accountNumber3 = scan.nextInt();
                System.out.println("Ange vilket belopp, tänk på att summan måste finnas tillgängligt på konton, se nedan summa " + ("\n"));
                System.out.println(bank.findByNumber(accountNumber3).getAmount());

                double amount = scan.nextDouble();
                if(bank.findByNumber(accountNumber3) != null 
                        && bank.findByNumber(accountNumber3).getAmount() >= amount){
                        bank.findByNumber(accountNumber3).withdraw(amount);
                    } else if(bank.findByNumber(accountNumber3).getAmount() <= 0.0){
                        System.out.println("Uttaget misslyckades, endast " + bank.findByNumber(accountNumber3).getAmount()
                        + " på kontot!" + ("\n"));
                    } else{
                        System.out.println("Kontonummer finns inte registrerat, skapa först ett konto" + ("\n"));
                    }

                    break;

                case "5":

                scan.nextLine();
                System.out.println("Vilket konto vill du överföra från?" + ("\n"));
                int fromAccount = scan.nextInt();
                System.out.println("Vilket konto vill du överföra till?" + ("\n"));
                int toAccount = scan.nextInt();
                System.out.println("Hur mycket vill du överföra?" + ("\n"));
                double amount1 = scan.nextDouble();

                
                if(bank.findByNumber(fromAccount) != null && bank.findByNumber(toAccount) != null){
                    if(bank.findByNumber(fromAccount).getAmount() >= amount1){
                        bank.findByNumber(fromAccount).withdraw(amount1);
                        bank.findByNumber(toAccount).deposit(amount1);
                        System.out.println("Överföringen lyckades!" + ("\n"));
                        System.out.println(bank.findByNumber(fromAccount));
                        System.out.println(bank.findByNumber(toAccount));
                    } else if(bank.findByNumber(fromAccount).getAmount() < 0){
                        System.out.println("Överföring misslyckades, endast " + bank.findByNumber(fromAccount).getAmount()
                    + " på kontot!" + ("\n"));
                    }else{
                        System.out.println("Kontonummer är finns ej, skapa ett kontonummer först!" + ("\n"));
                    }

                }
                    break;

                case "6":

                scan.nextLine();
                System.out.println("ID: ");
                long idNr = scan.nextLong();
                ArrayList<BankAccount> holderAccounts = bank.findAccountsForHolder(idNr);
                for(int i = 0; i < holderAccounts.size(); i++){
                    System.out.println(holderAccounts.get(i).toString());
                }

                    break;

                case "7":

                scan.nextLine();
                System.out.println("Ange den del av namn du vill söka på" + ("\n"));
                String namePart = scan.nextLine();
                ArrayList<Customer> partName = bank.findByPartOfName(namePart);

                for(Customer customer : partName){
                    ArrayList<BankAccount> customerAccounts = bank.findAccountsForHolder(customer.getIdNr());
                    for(BankAccount customerAccount : customerAccounts){
                        System.out.println(customerAccount.toString());
                    }
                }

                    break;

                case "8":

                scan.nextLine();
                ArrayList<BankAccount> sortedAccounts = bank.getAllAccounts();
                for(BankAccount sortedAccount : sortedAccounts){
                    System.out.println(sortedAccount.toString());
                }
                    break;

                case "9":

                scan.nextLine();
                System.out.println("Tack för att du använde bank appen, hoppas att se dig snart igen :)" + ("\n"));
                System.exit(0);

                    break;

                case "10":

                scan.nextLine();
                RunGame.main(bank);

            default:
                break;

            }

        }
    }

    public static void textMenu(){
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
System.out.println("\n");
        
        System.out.println("Hej, välkommen till denna bank appen. Vi finns här för att underlätta dit liv. ");
System.out.println("\n");
        System.out.println("Välj gärna en av följande alternativ, vi erbjuder mycket bra ränta. ");
System.out.println("\n");

        System.out.println("1. Skapa nya konton ");//CASE 6
System.out.println("\n");
        System.out.println("2. Ta bort konton du har ");//CASE 7
System.out.println("\n");
        System.out.println("3. Sätt in pengar på konto, kontonummer måste anges korrekt! ");
System.out.println("\n");
        System.out.println("4. Ta ut pengar från konto, kontonummer måste anges korrekt! ");
System.out.println("\n");
        System.out.println("5. Vill du överföra pengar mellan olika konton, använd detta alternativ ");
System.out.println("\n");
        System.out.println("6. Hitta konto utifrån innehavare ");//CASE 1
System.out.println("\n");
        System.out.println("7. Sök kontoinnehavare utifrån del av namn ");//CASE 2
System.out.println("\n");
        System.out.println("8. Skriv ut alla konton som finns på appen, ENDAST FÖR ARBETANDE ");
System.out.println("\n");
        System.out.println("9. Vill du avsluta appen, välj detta alternativ ");
System.out.println("\n");
System.out.println("10. Starta spel ");
System.out.println("\n");
        System.out.print("Ditt val:  ");
    }
    
}
