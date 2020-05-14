
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.io.*;

public class Bookstore{

    public String Name;
    public String Address;
    public int SqFt;
    public boolean HasNewBooks;
    public boolean HasUsedBooks;

    private boolean open;
    private boolean openWeekends;
    private LocalDate today = LocalDate.now();
    private int dayOfWeek = today.getDayOfWeek().getValue();
    private int currentTime = LocalTime.now().getHour();
    private ArrayList<String> titles;

    
    private static final int OPENING_TIME = LocalTime.parse("07:00").getHour();
    private static final int CLOSING_TIME = LocalTime.parse("20:00").getHour();

    //Public Methods

    public Bookstore() {
        this.Name = "Your Bookstore Name";
        this.Address = "1234 Books Ave";
        this.SqFt = 1300;
        this.HasNewBooks = true;
        this.HasUsedBooks = true;
        this.open = this.isOpen(currentTime); //needs to be adjusted;
        this.openWeekends = true;

        //Load Titles
        titles = new ArrayList<String>();
        loadTitles();
    }

    public Bookstore(String name, String address) {
        this.Name = name;
        this.Address = address;
        this.SqFt = 1000;
        this.HasNewBooks = true;
        this.HasUsedBooks = true;
        this.open = this.isOpen(currentTime); //needs to be adjusted;
        this.openWeekends = true;

        //Load Titles
        titles = new ArrayList<String>();
        loadTitles();
    }

    public Bookstore(String name, String address, int sqft) {
        this.Name = name;
        this.Address = address;
        this.SqFt = sqft;
        this.HasNewBooks = true;
        this.HasUsedBooks = true;
        this.open = this.isOpen(currentTime); //needs to be adjusted;
        this.openWeekends = true;

        // Load Titles
        titles = new ArrayList<String>();
        loadTitles();
    }

    
    public boolean isOpen() {

        if (!this.openWeekends & dayOfWeek == 6 && dayOfWeek == 7) {
            this.open = false;
        }

        if (this.open) {
            System.out.println("Yes, the store is open right now");
            return true;
        } else {
            System.out.println("No, the store is currently closed");
            return false;
        }
    }

    // Private Internal Methods

    private boolean isOpen(int time) {

        if (time >= OPENING_TIME && time < CLOSING_TIME) {
            return true;
        } else {
            return false;
        }
    }

    private void loadTitles() {
        try {
            Utils.loadStringsToArray(this.titles);
        } catch (IOException e) {
            // for now simply init the array to zero
            System.out.println("Could not initilize the titles");
            // make sure it is empty
            this.titles = new ArrayList<String>();
        }
    }

    // Setter and Getter Methods

    //Methods for setting and getting Name
    public String getName() {System.out.println(Name); return Name;}
    public void setName(String name) {this.Name = name;}

    //Methods for setting and getting Address
    public String getAddress() {System.out.println(Address); return Address;} 
    public void setAddress(String address) {this.Address = address;}

    //Methods for setting and getting SqFt
    public int getSqFt() {System.out.println(SqFt + " sqft"); return SqFt;}
    public void setSqFt(int squareFeet) {this.SqFt = squareFeet;}

    //Method for setting and getting hasNewBooks
    public boolean getHasNewBooks(){System.out.println("Does this store have New Books? : " + HasNewBooks); return HasNewBooks;}
    public void setHasNewBooks(boolean newBook){this.HasNewBooks = newBook;}

    //Method for setting and getting hasUsedBooks
    public boolean getHasUsedBooks(){System.out.println("Does this store have Used Books? : " + HasUsedBooks); return HasUsedBooks;}
    public void setHasUsedBooks(boolean used){this.HasUsedBooks = used;}

    //Method to get store hours
    public void getStoreHours() {
        System.out.println("Store Hours are from " + OPENING_TIME + ":00 to " + CLOSING_TIME + ":00.");
    }

    //Method for getting titles 
    public void getTitles () {
        System.out.println("Beginning of Book List:");
        for (String book : titles) {
            System.out.println(book);
        }
        System.out.println("End of Book List:");
    }

    public static void main(String[] args) {
        
        //Create a bookstore with properties
        Bookstore hecStore = new Bookstore("Hector's Bookstore", "123 Make Believe Ave");

        //What is the address?
        hecStore.getAddress();      
        
        //Is the store open today?
        hecStore.isOpen();
        
        //What time does is close?
        hecStore.getStoreHours();

        //How big is the store? 
        hecStore.getSqFt();

        //Does the store have new or used books?
        hecStore.getHasNewBooks();
        hecStore.getHasUsedBooks();

        //Print a list of the books
        hecStore.getTitles();

    }

}