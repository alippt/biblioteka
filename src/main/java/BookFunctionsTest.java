import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class BookFunctionsTest {
    List<Book> bookListTest = new ArrayList<>();

    @Before
    public void addBooks() {

        Book book1 = new Book("Pierwsza", "1999", "12345");
        Book book2 = new Book("Druga", "2001", "1256");
        Book book3 = new Book("Trzecia", "2005", "2564");
        Book book4 = new Book("Czwarta", "2010", "1258");
        Book book5 = new Book("Piąta", "1986", "125687");
        Book book6 = new Book("Szósta", "2017", "12547");

        bookListTest.add(book1);
        bookListTest.add(book2);
        bookListTest.add(book3);
        bookListTest.add(book4);
        bookListTest.add(book5);
        bookListTest.add(book6);
    }

    //zad 1 for
    @Test
    public void findISBN() {
        Book book = BookFunctions.findBook("12345", bookListTest);
        Assert.assertEquals("Pierwsza", book.getTitle());
    }

    //zad 1 streeam
    @Test
    public void findISBNStream() {
        Optional<Book> book = BookFunctions.findBookStream("12345", bookListTest);
        Assert.assertEquals("Pierwsza", book.get().getTitle());
    }

    //zad 2
    @Test
    public void findTwoLastBook() {
        List<Book> sub = BookFunctions.findTwoLastBook(bookListTest);
        Assert.assertEquals(bookListTest.subList(4, 5), sub);
    }
    //zad2 Stream
    @Test
    public void findTwoLastBookStream(){
        List<Book>subL = BookFunctions.findTwoLastBookStream(bookListTest);
//        Assert.assertTrue(subL.get(4).getTitle().equals("Piąta"));
        Assert.assertEquals(bookListTest.subList(4,5), subL);
//        Assert.assertTrue(bookListTest.subList(4,5).equals(subL));
    }

    //zad3
    @Test
    public void findMinYearBook() {
        Book book = BookFunctions.minYearBook(bookListTest);
        Assert.assertEquals("Piąta", book.getTitle());
    }

    //zad 3 stream
    @Test
    public void findMinYearBookStream() {
        Optional<Book> book = BookFunctions.minYearBookStream(bookListTest);
        Assert.assertEquals("Piąta", book.get().getTitle());
    }
    //zad 4
    @Test
    public void findMaxYearBook() {
        Book book = BookFunctions.maxYearBook(bookListTest);
        Assert.assertEquals("Szósta", book.getTitle());
    }
    //zad 4 stream
    @Test
    public void findMaxYearBookStream(){
        Optional<Book> book= BookFunctions.maxYearBookStream(bookListTest);
        Assert.assertEquals("Szósta", book.get().getTitle());
    }
    //zad 5
    @Test
    public void allBooksAfterYear(){
        boolean allBooksAfterYear = BookFunctions.allBooksAfterYear(bookListTest, 2000);
        Assert.assertFalse("are all books after" , allBooksAfterYear);
    }
    //zad 5
}
