import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        Library library = new Library();
        library.LibraryBooks();
        List<Book> books = library.getBooks();
        BookLending bookLending = new BookLending();


        JFrame frame = new JFrame("Library Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);


        JPanel panel = new JPanel();
        panel.setLayout(null);


        JLabel bookLabel = new JLabel("Select Book:");
        bookLabel.setBounds(30, 30, 100, 30);
        panel.add(bookLabel);

        String[] bookTitles = new String[books.size()];
        for (int i = 0; i < books.size(); i++) {
            bookTitles[i] = books.get(i).getBookTitle();
        }
        JComboBox<String> bookDropdown = new JComboBox<>(bookTitles);
        bookDropdown.setBounds(140, 30, 200, 30);
        panel.add(bookDropdown);


        JButton borrowButton = new JButton("Borrow");
        borrowButton.setBounds(50, 100, 150, 30);
        borrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedBook = (String) bookDropdown.getSelectedItem();
                bookLending.Borrow(selectedBook, books.toArray(new Book[0]));
                JOptionPane.showMessageDialog(frame, "Book Borrowed!");
            }
        });
        panel.add(borrowButton);


        JButton returnButton = new JButton("Return");
        returnButton.setBounds(250, 100, 150, 30);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedBook = (String) bookDropdown.getSelectedItem();
                bookLending.Return(selectedBook, books.toArray(new Book[0]));
                JOptionPane.showMessageDialog(frame, "Book Returned!");
            }
        });
        panel.add(returnButton);


        JButton detailsButton = new JButton("Show Details");
        detailsButton.setBounds(150, 200, 150, 30);
        detailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedBook = (String) bookDropdown.getSelectedItem();
                for (Book book : books) {
                    if (book.getBookTitle().equals(selectedBook)) {
                        JOptionPane.showMessageDialog(frame,
                                "Book Details:\nTitle: " + book.getBookTitle() +
                                        "\nAuthor: " + book.getBookAuthor() +
                                        "\nAvailability: " + (book.getAvailable() ? "Available" : "available after "+bookLending.getDueDate()));

                        break;
                    }
                }
            }
        });
        panel.add(detailsButton);


        frame.add(panel);


        frame.setVisible(true);
    }
}
