import java.time.LocalDate;

public class BookLending {
    private String name;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    public LocalDate getborrowDate()
    {
        return borrowDate;
    }
    public LocalDate getDueDate()
    {
        return dueDate;
    }

    public void Borrow(String B,Book[] books)
    {
        int i=0;
        while (books[i]!=null)
        {
            if(books[i].getBookTitle().equals(B))
            {
                break;
            }
            i++;
        }
        if(B.equals(books[i].getBookTitle()))
        {
            borrowDate=LocalDate.now();
            dueDate=borrowDate.plusDays(15);
            books[i].borrowBook();
        }
    }
    public void Return(String B,Book[] books)
    {
        int i=0;
        while (books[i]!=null)
        {
            if(books[i].getBookTitle().equals(B))
            {
                break;
            }
            i++;
        }
        if(B.equals(books[i].getBookTitle()))
        {
            returnDate=LocalDate.now();
            if(returnDate.isAfter(dueDate))
            {
                System.out.println("book should be submitted before due date");
            }
            books[i].returnBook();
        }
    }
}
