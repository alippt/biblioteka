import java.io.*;

public class BookList {
    public static void readBookList() throws IOException {
        BufferedReader readList = new BufferedReader ( new FileReader ( "C:/Users/ABMtr/Desktop/JAva sda/bibliotekaZajecia/books.csv" ) );

        String textLine = readList.readLine ();
        do {
            System.out.println ( textLine );
            textLine=readList.readLine ();
        } while (textLine != null);
        readList.close ();
    }

}
