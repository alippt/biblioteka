import java.util.Scanner;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class Menu {
    static Scanner scanner = new Scanner ( System.in );

static String cos;
    static void menu()  {

        System.out.println ( "1. Wyświetl liste ksiązek" );
        System.out.println ( "2. Wyjdź" );
        cos = scanner.nextLine ();
        if (isNumeric ( cos )) {
            userChoice ();
        }else {
            System.out.println ("Wybierz liczbę 1 lub 2");
            menu ();
        }
    }

    static void userChoice() {
        int option= Integer.parseInt ( cos );
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

