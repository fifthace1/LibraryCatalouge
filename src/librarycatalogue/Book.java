
package librarycatalogue;

/**
 *
 * @author m.ashoori
 */
public class Book {
    
    String title;
    int pageCount;
    int ISBN;
    boolean isCheckedOut; // book checked out or not
    int dayCheckedOut = -1;
    
    public Book(String bookTiltle, int bookPageCount, int bookISBN)
    {
        this.title = bookTiltle;
        this.pageCount = bookPageCount;
        this.ISBN = bookISBN;
        isCheckedOut = false;
    }
    
    //Getters - Instance Method
    public String getTitle()
    {
        return this.title;
    }
    
    public int getPageCount()
    {
        return this.pageCount;
    }
    
    public int getISBN()
    {
        return this.ISBN;
    }
    
    public boolean getIsCheckedOut()
    {
        return this.isCheckedOut;
    }
    
    public int getDayCheckedOut()
    {
        return this.dayCheckedOut;
    }
    
    // Setters
    public void setIsCheckedOut(boolean  newIsCheckedOut, int currentDayCheckedOut)
    {
        this.isCheckedOut = newIsCheckedOut;
        setDayCheckedOut(currentDayCheckedOut);
    }
    
    private void setDayCheckedOut(int day)
    {
        this.dayCheckedOut = day;
    }
}
