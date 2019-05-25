import java.util.List;
import java.util.Optional;
import java.util.Comparator;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.collect;

public class BookFunctions extends Book {

    public BookFunctions(String title, String year, String ISBN) {
        super(title, year, ISBN);
    }

    //zad 1
    public static Book findBook(String ISBN, List<Book> bookList) {

        for (Book book : bookList) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    //zad1 stream
    public static Optional<Book> findBookStream(String ISBN, List<Book> bookList) {

        Optional<Book> book = bookList.stream()
                .filter(book1 -> book1.getISBN().equals(ISBN))
                .findFirst();
        return book;
    }

    //zad 2
    public static List<Book> findTwoLastBook(List<Book> bookList) {
        List<Book> sub = bookList.subList(bookList.size() - 2, bookList.size() - 1);
        return sub;
    }

    //zad2 Stream
//    public static List<Book> findTwoLastBookStream(List<Book>bookList){
//        List<Book> listBook = bookList.stream()
//                .filter(e->bookList.subList(bookList.size()-1,bookList.size()-2))  // FK! NIE WIEM JAK TO Zrobic
//                .collect(Collectors.toList());
//
//        return listBook;
//    }
//
    //zad 3
    public static Book minYearBook(List<Book> bookList) {
        Book book;
        int ind = -1;
        int minyear = 9999;
        for (int i = 0; i < bookList.size(); i++) {
            int year = Integer.parseInt(bookList.get(i).getYear());
            if (year < minyear) {
                ind = i;
                minyear = year;
            }
        }
        book = bookList.get(ind);
        return book;

    }

    //zad 3 stream
    public static Optional<Book> minYearBookStream(List<Book> bookList) {


        Optional<Book> book = bookList.stream()
                .min(Comparator.comparing(Book::getYear));
        return book;
    }

    //zad 4
    public static Book maxYearBook(List<Book> bookList) {
        Book book;
        int ind = -1;
        int maxyear = 0;
        for (int i = 0; i < bookList.size(); i++) {
            int year = Integer.parseInt(bookList.get(i).getYear());
            if (year > maxyear) {
                ind = i;
                maxyear = year;
            }
        }
        book = bookList.get(ind);
        return book;

    }
    //zad 4 stream
    public static Optional<Book> maxYearBookStream(List<Book> bookList) {


        Optional<Book> book = bookList.stream()
                .max(Comparator.comparing(Book::getYear));
        return book;
    }
}


