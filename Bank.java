import java.util.ArrayList;

public class Bank {
    private ArrayList<BankAccount> accounts;
/** Skapar en ny bank utan konton. */
    public Bank(){
        this.accounts = new ArrayList<BankAccount>();

    }
/**
* Öppna ett nytt konto i banken. Om det redan finns en kontoinnehavare
* med de givna uppgifterna ska inte en ny Customer skapas, utan istället
* den befintliga användas. Det nya kontonumret returneras.
*/
    public int addAcount(String holderName, long idNr){
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i).getHolder().getIdNr() == idNr || 
            accounts.get(i).getHolder().getName().equals(holderName)){
                BankAccount newAccount = new BankAccount(accounts.get(i).getHolder());
                accounts.add(newAccount);
                return newAccount.getAccountNumber();
            }
        }
        BankAccount newAccount = new BankAccount(holderName, idNr);
        accounts.add(newAccount);
        return newAccount.getAccountNumber();
        
    }
    /**

* Returnerar den kontoinnehavaren som har det givna id-numret,
* eller null om ingen sådan finns.
*/
    public Customer findHolder(long idNr){
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i).getHolder().getIdNr() == idNr){
                return accounts.get(i).getHolder();
            }
        }
        return null;
        
    }   
/**

* Tar bort konto med nummer 'number' från banken. Returnerar true om
* kontot fanns (och kunde tas bort), annars false.
*/
    public boolean removeAccount(int number){
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i).getAccountNumber() == number){
                accounts.remove(i);
                return true;
            }
        }
        return false;
        
    }
/**

* Returnerar en lista innehållande samtliga bankkonton i banken.
* Listan är sorterad på kontoinnehavarnas namn.
*/
    public ArrayList<BankAccount> getAllAccounts(){
        ArrayList<BankAccount> sortedAccounts = new ArrayList<BankAccount>();
        for(int i = 0; i < accounts.size(); i++){
            sortedAccounts.add(accounts.get(i));
        }


        for(int i = 0; i < sortedAccounts.size(); i++){
            for(int j = i + 1; j < sortedAccounts.size(); j++){
                if(sortedAccounts.get(i).getHolder().getName().compareTo(sortedAccounts.get(j).getHolder().getName()) > 0){
                    BankAccount temp = sortedAccounts.get(i);
                    sortedAccounts.set(i, sortedAccounts.get(j));
                    sortedAccounts.set(j, temp);
                }
            }
        }
        return sortedAccounts;
        
    }
/**

* Söker upp och returnerar bankkontot med kontonummer'accountNumber'
* Returnerar null om inget sådant konto finns.
*/
    public BankAccount findByNumber(int accountNumber){
        
    }

    /**

* Söker upp alla bankkonton som innehas av kunden med id-nummer'idNr'
* Kontona returneras i en lista. Kunderna antas ha unika id-nummer.
*/
    public ArrayList<BankAccount> findAccountsForHolder(long idNr){
        
    }

/**
* Söker upp kunder utifrån en sökning på namn eller del av namn. Alla
* personer vars namn innehåller strängen'namePart' inkluderas i
* resultatet, som returneras som en lista. Samma person kan förekomma
* flera gånger i resultatet. Sökningen är "case insensitive", det vill
* säga gör ingen skillnad på stora och små bokstäver.
*/
    public ArrayList<Customer> findByPartOfName(String namePart){
        
    }



    
}
