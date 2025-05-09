

public class Book {
    private Integer BookId;
    private String BookAuthor;
    private String BookTitle;
    private Boolean Available=true;
    Book(Integer BookId,String BookAuthor,String BookTitle)
    {
        this.BookId=BookId;
        this.BookAuthor=BookAuthor;
        this.BookTitle=BookTitle;

    }
    public Integer getBookId()
    {
        return BookId;
    }
    public String getBookAuthor()
    {
        return BookAuthor;
    }
    public String getBookTitle()
    {
        return BookTitle;
    }
    public Boolean getAvailable()
    {
        return Available;
    }
    public void borrowBook()
    {
        if(Available)
        {
            Available=false;
            System.out.println("borrowed");
        }
        else
        {
            System.out.println("unavailable");
        }
    }
    public void returnBook()
    {
        Available=true;
        System.out.println("returned");
    }
}
