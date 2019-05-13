import java.io.IOException;
import java.util.Scanner;

public class Menu1 {
    static Scanner scanner = new Scanner(System.in);


    static void menu() throws IOException {
        int option = 0;
        System.out.println("1. Wyświetl liste ksiązek");
        System.out.println("2. Wyjdź");
        while (option != 2) {
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    BookList.readBookList();
                    break;
                case 2:
                    System.out.println("Do widzenia");
                    break;
            }
        }
    }
}

