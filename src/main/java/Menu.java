import java.util.Scanner;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class Menu {
    static Scanner scanner = new Scanner ( System.in );

static String numericOrText;
    static void menu()  {

        System.out.println ( "1. Wyświetl liste ksiązek" );
        System.out.println ( "2. Wyjdź" );
        numericOrText = scanner.nextLine ();
        if (isNumeric ( numericOrText )) {
            userChoice ();
        }else {
            System.out.println ("Wybierz liczbę 1 lub 2");
            menu ();
        }
    }

    static void userChoice() {
        int option= Integer.parseInt ( numericOrText );
        while (option != 2) {
            switch (option) {
                case 1:
                    BookList.readBookList ();
                    break;
                case 2:
                    break;
                default:
                    System.out.println ( "wybierz 1 lub 2" );
                    menu();
                    break;
            }
        }
    }
}

