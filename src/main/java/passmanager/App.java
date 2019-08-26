package passmanager;

import java.util.Scanner;

public class App {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {



        while (true) {
            System.out.println("Co chcesz zrobić?\n1. Dodaj nowe hasło.\n2. Odczytaj hasło.\n3. Zaktualizuj hasło.\n4. Usuń hasło.\n 0. Wyjdź");
            String input = sc.nextLine();
            if (input.equals("1")) {
                addPasswordEntry();
            } else if (input.equals("2")) {
                readPasswordEntry();
            } else if (input.equals("3")) {
                System.out.println();
            } else if (input.equals("4")) {
                System.out.println();
            } else if (input.equals("0") || input.equalsIgnoreCase("exit")) {
                System.exit(0);
            } else {
                System.out.println("Niepoprawny wybór");
            }
        }
    }

    public static void addPasswordEntry() {
        System.out.println("Podaj nazwę strony:");
        String siteName = sc.nextLine();
        System.out.println("Podaj login:");
        String login = sc.nextLine();
        System.out.println("Podaj hasło:");
        String passwordEncrypted = sc.nextLine();
        System.out.println("Podaj opis");
        String description = sc.nextLine();
        PasswordEntry passwordEntry = new PasswordEntry(0, passwordEncrypted, siteName, login, description);
    }

    public static void readPasswordEntry() {

    }

}