import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookList {

    static Scanner scanner = new Scanner ( System.in );
    static String addedBook;
    static List<Book> bookList = new ArrayList<Book> ();

    public static void readBookList() throws IOException {
        BufferedReader readList = new BufferedReader ( new FileReader ( "C:/Users/ABMtr/Desktop/JAva sda/bibliotekaZajecia/books.csv" ) );

        String textLine = readList.readLine ();

        do {
            String[] split = textLine.split ( ";" );
            String title = split[0];
            String ISBN = split[1];
            String year = split[2];
            System.out.println ( title + " " + year + " " + ISBN );
            Book book = new Book ( title, year, ISBN );
            bookList.add ( book );
            textLine = readList.readLine ();
        } while (textLine != null);
        readList.close ();
        bookMenu ();
    }

    static void addBook() {
        System.out.println ( "podaj tytuł" );
        String addtitle = scanner.nextLine ();
        System.out.println ( "podaj rok wydania" );
        String addyear = scanner.nextLine ();
        System.out.println ( "podaj ISBN" );
        String addISBN = scanner.nextLine ();
        bookList.add ( new Book ( addtitle, addyear, addISBN ) );

    }

    static void deleteBook() {
        String toDelete = "pusty";
        System.out.println ( "Podaj tytuł książki, którą chcesz usunąć" );
        toDelete = scanner.nextLine ();
        int index = -1;
        for (int i = 0; i < bookList.size (); i++) {
            Book book = bookList.get ( i );
            if (book.getTitle ().equals ( toDelete )) { //gdy to mi pasuje przypisuje indeks tej książki do zmiennej index
                index = i;
            }
        }
        bookList.remove ( index );  //usuwanie poza forem bo nie mogę usuwać podczas przechodzenia przez pętlę
        System.out.println ( "jeśli chcesz zachować te zmiany wybierz 4" );
    }

    static void editBook() {
        String toEdit = "pusty";
        System.out.println ( "Podaj tytuł książki, którą chcesz edytować" );
        toEdit = scanner.nextLine ();
        int index = -1;
        for (int i = 0; i < bookList.size (); i++) {
            Book book = bookList.get ( i );
            if (book.getTitle ().equals ( toEdit )) { //gdy to mi pasuje przypisuje indeks tej książki do zmiennej index
                index = i;
            }
        }
        System.out.println ("zmień rok wydania"); //TODO działa do wczytania roku, później coś wywala
        String newYear= "pusty";
        newYear = scanner.nextLine ();
//        Book bookToEdit= bookList.get ( index );
//        bookToEdit.setYear (newYear); //zmiana poza forem bo nie mogę zmienić podczas przechodzenia przez pętlę
//        System.out.println ( "jeśli chcesz zachować te zmiany wybierz 4" );

    }

    static void writeListOfBook() throws IOException {
        BufferedWriter writeListOfBook = new BufferedWriter ( new FileWriter ( "C:/Users/ABMtr/Desktop/JAva sda/bibliotekaZajecia/books.csv" ) );
        for (Book book : bookList) {
            String line = ((book.getTitle ()) + ";" + (book.getISBN ()) + ";" + (book.getYear ()));
            writeListOfBook.write ( line );
            writeListOfBook.newLine ();
        }
//        for (int i = 0; i < bookList.size (); i++) {
//            Book book = bookList.get ( i );
//            String line = ((book.getTitle ()) + ";" + (book.getISBN ()) + ";" + (book.getYear ()));
//            writeListOfBook.write ( line );
//            writeListOfBook.newLine ();
//        }
        writeListOfBook.close ();
    }

    public static void bookMenu() throws IOException {
        int option;

        do {
            System.out.println ( "1. Dodaj książkę" );
            System.out.println ( "2. Usuń książkę" );
            System.out.println ( "3. Edytuj książkę" );
            System.out.println ( "4. Zapisz listę książek" );
            System.out.println ( "5. Powrót do głównego menu" );
            option = Integer.parseInt ( scanner.nextLine () );
            switch (option) {
                case 1:
                    addBook ();
                    break;
                case 2:
                    deleteBook ();
                    break;
                case 3:
                    editBook ();
                    break;
                case 4:
                    writeListOfBook ();
                    break;
                case 5:
                    Menu1.menu ();

            }
        }
        while (option != 5);
    }
}
