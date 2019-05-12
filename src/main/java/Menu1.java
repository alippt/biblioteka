import java.io.IOException;
import java.util.Scanner;

public class Menu1 {
    static Scanner scanner = new Scanner ( System.in );


    static void exit() {
        System.out.println ( "Do widzenia" );
    }

    static void menu() throws IOException {
        int option;

        do {
            System.out.println ( "1. Wyświetl liste ksiązek" );
            System.out.println ( "2. Wyjdź" );
            option = scanner.nextInt ();
            switch (option) {
                case 1:
                    BookList.readBookList ();
                    break;
                case 2:
                    exit ();
                    break;
            }
        }
        while (option!=2);

            }
        }

