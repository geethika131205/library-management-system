
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Library{
    List<Book> books=new ArrayList<>();
    public  void LibraryBooks () throws Exception

    {

            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\geeth\\IdeaProjects\\libraryManagment\\src\\data.txt"));


            String l;
            while ((l=br.readLine()) != null) {
                String[] a = l.split(",");
                books.add(new Book(Integer.parseInt(a[0]), a[1], a[2]));

            }
    }
        public List<Book> getBooks()
        {
            return books;
        }


}
