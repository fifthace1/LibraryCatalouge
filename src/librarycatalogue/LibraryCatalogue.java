
package librarycatalogue;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author m.ashoori
 */
public class LibraryCatalogue {
    
    Map<String,Book> bookCollection = new HashMap<String, Book>();
    int currentDay = 0;
    int lengthOfCheckOutPeriod = 7;
    double initialLateFee = 0.50;
    double feePerLateDay = 1.00;
    
    public LibraryCatalogue(Map<String,Book> collection)
    {
        this.bookCollection = collection;
    }
    
    public LibraryCatalogue(Map<String,Book> collection, int lengthOfCheckoutPeriod,
            double initialLateFee, double feePerLateDay)
    {
        this.bookCollection = collection;
        this.lengthOfCheckOutPeriod = lengthOfCheckoutPeriod;
        this.initialLateFee = initialLateFee;
        this.feePerLateDay = feePerLateDay;
    }
    
    // Getters
    public int getCurrentDay()
    {
        return this.currentDay;
    }
    
    public Map<String,Book> getBookCollection()
    {
        return this.bookCollection;
    }
    
    public Book getBook(String bookTitle)
    {
        return getBookCollection().get(bookTitle);
    }
    
    public int getLengthOfCheckOutPeriod()
    {
        return this.lengthOfCheckOutPeriod;
    }
    
    public double  getInitialLateFee()
    {
        return this.initialLateFee;
    }
    
    public double getFeePerLateDay()
    {
        return this.feePerLateDay;
    }
    
    
    // Setters
    public void nextDay()
    {
        currentDay++;
    }
    
    public void setDay(int day)
    {
        currentDay = day;
    }
    
    public void checkOutBook(String title)
    {
        Book book = getBook(title);
        if (book.getIsCheckedOut())
            sorryBookAlreadyCheckedOut(book);
        else{
            book.setIsCheckedOut(true, currentDay);
            System.out.println("You just checked out " + title + ". It is due on day " + 
                    (getCurrentDay() + getLengthOfCheckOutPeriod())+".");
        }
    }
    
    public void returnBook(String title)
    {
        Book book = getBook(title);
        int daysLate = currentDay - (book.getDayCheckedOut() + getLengthOfCheckOutPeriod());
        if (daysLate > 0)
        {
            System.out.println("You owe the library $" + (getInitialLateFee()+
                    daysLate * getFeePerLateDay()) +
                    " because your book is " + daysLate + " days overdue");
        }
        else
        {
            System.out.println("Book Returned. Thank you");
        }
        book.setIsCheckedOut(false, -1);
    }
    
    public void sorryBookAlreadyCheckedOut(Book book)
    {
        System.out.println("Sorry, " + book.getTitle() + " is already checked out." + 
                "It should be back on day " + (book.getDayCheckedOut() +
                getLengthOfCheckOutPeriod()) + ".");
    }
            
    public static void main(String[] args) {
        Map<String,Book> bookcollection = new HashMap<>();
        Book harry = new Book("Harry Potter", 800, 71636173);
        bookcollection.put("Harry Potter", harry);
        LibraryCatalogue lib = new LibraryCatalogue(bookcollection);
        lib.checkOutBook("Harry Potter");
        lib.nextDay();
        lib.nextDay();
        lib.checkOutBook("Harry Potter");
        lib.setDay(17);
        lib.returnBook("Harry Potter");
        lib.checkOutBook("Harry Potter");
    }
    
}
