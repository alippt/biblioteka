import java.util.List;

public class BookFunctions {
    //Stream
    //zad 1
    public static Book findBook(String ISBN, List<Book> bookList){
        Book book = null;
        bookList.stream()
                .filter(book1 ->(book.getISBN().equals(ISBN)));

        return book;
    }
}
