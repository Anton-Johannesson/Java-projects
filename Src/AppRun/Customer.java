package Src.AppRun;


public class Customer {
    private String name;
    private long idNr;


/**
* Skapar en kund (kontoinnehavare) med namnet'name' och id-nummer 'idNr'
* Kunden tilldelas också ett unikt kundnummer.
*/
    public Customer(String name, long idNr) {
        this.name = name;
        this.idNr = idNr;
    }
/** Tar reda på kundens namn. */
    public String getName(){
        return name;
    }
/** Tar reda på kundens kundnummer. */
    public long getIdNr(){
        return idNr;
    }
/** Returnerar en strängbeskrivning av kunden. */
    public String toString(){
        return name + ", id " + idNr;
    }


    
}
