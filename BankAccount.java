
import java.util.Random;

public class BankAccount {
    private int accountNumber;
    private double amount;
    private Customer customer;
    Random rand = new Random();
/**
* Skapar ett nytt bankkonto åt en innehavare med namn'holderName' och
* id 'holderId'. Kontot tilldelas ett unikt kontonummer och innehåller
* inledningsvis 0 kr.
*/
    public BankAccount(String holderName, long holderId){
        this.customer = new Customer(holderName, holderId);
        this.accountNumber = rand.nextInt(1000000) + 100000;
        this.amount = 0.0;
        
    }
/**

* Skapar ett nytt bankkonto med innehavare'holder'. Kontot tilldelas
* ett unikt kontonummer och innehåller inledningsvis 0 kr.
*/
    public BankAccount(Customer holder){
        customer = holder;
        accountNumber = rand.nextInt(1000000) + 100000;
        amount = 0.0;


    }
/** Tar reda på kontots innehavare. */
    public Customer getHolder(){
        return customer;

    }
/** Tar reda på det kontonummer som identifierar detta konto. */
    public int getAccountNumber(){
        return accountNumber;

    }
/** Tar reda på hur mycket pengar som finns på kontot. */
    public double getAmount(){
        return amount;

    }
/** Sätter in beloppet'amount' på kontot. */
    public void deposit(double amount){
        this.amount += amount;

    }
/**
* Tar ut beloppet'amount' från kontot. Om kontot saknar täckning
* blir saldot negativt
*/
    public void withdraw(double amount){
        this.amount -= amount;

    }

    /** Returnerar en strängrepresentation av bankkontot. */
    public String toString(){
        return "konto: " + accountNumber + " (" + this.customer.toString() + ") : " + amount;

    } 
    
}
