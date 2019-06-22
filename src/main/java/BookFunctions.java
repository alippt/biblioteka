import java.util.List;
import java.util.Optional;
import java.util.Comparator;
import java.util.stream.Collectors;

import static jdk.nashorn.internal.objects.NativeArray.reduce;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.collect;

public class BookFunctions extends Book {

    public BookFunctions(String title, String year, String ISBN) {
        super(title, year, ISBN);
    }

    //zad 1 Znajdź książkę o podanym ISBN. Metoda przyjmuje 2 parametry (isbn, lista wszystkich książek) i zwraca podaną książkę.
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

    //zad 2 Zwróć dwie ostatnie książki.
    public static List<Book> findTwoLastBook(List<Book> bookList) {
        List<Book> sub = bookList.subList(bookList.size() - 2, bookList.size() - 1);
        return sub;
    }

    //zad2 Stream
    public static List<Book> findTwoLastBookStream(List<Book> bookList) {
        List<Book> listBook = bookList.stream()
                .filter(e -> e.getTitle().equals(bookList.subList((bookList.size() - 2), (bookList.size() - 1))))  // FK! NIE WIEM JAK TO Zrobic
                .collect(Collectors.toList());
        return listBook;
    }

    //
    //zad 3 Zwróć najwcześniej wydana książkę.
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

    //zad 4 Zwróć najpóźniej wydana książkę.
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

    //zad 5 Zwróć sumę lat wydania wszystkich książek.
    public static int sumAllYears(List<Book> bookList) {
        int allBooksYears = 0;
        for (Book book : bookList) {
            allBooksYears += Integer.parseInt(book.getYear());
        }
        return allBooksYears;
    }

    //zad 5 stream
    public static int sumAllYearsStream(List<Book> bookList) {
        int allBooksYears = bookList.stream()
                .mapToInt(book -> Integer.parseInt(book.year))
                .sum();
        return allBooksYears;
    }

    //zad 6 Zwróć liczbę książek wydanych po 2007 roku.
    public static int numberOfBooksAfterYear(List<Book> bookList, int yearAfter) {
        int number = 0;
        for (Book book : bookList) {
            int year = Integer.parseInt(book.getYear());
            if (year > yearAfter) {
                number += 1;
            }
        }
        return number;
    }

    //zad 6 stream
    public static long numberOfBooksAfterYearStream(List<Book> booklist, int yearAfter) {
        long number= booklist.stream()
                .filter(book -> Integer.parseInt(book.year) > yearAfter)
                .count();
               return number;
    }

    //zad 7 Zwróć informacje o tym czy wszystkie książki w naszym katalogu są wydane po 2000 roku.
    public static boolean allBooksAfterYear(List<Book> bookList, int yearAfter) {
        boolean allBooksAferYear = true;
        for (Book book : bookList) {
            int year = Integer.parseInt(book.getYear());
            if (yearAfter > year) {
                allBooksAferYear = false;
            }
        }
        return allBooksAferYear;
    }

    //zad 7 stream
    public static boolean allBooksAfterYearStream(List<Book> bookList, int yearAfter) {
        boolean allBooksAfterYear = bookList.stream()
                .allMatch(book -> (Integer.parseInt(book.year)) > yearAfter);
        return allBooksAfterYear;
    }

    //zad 8

}


