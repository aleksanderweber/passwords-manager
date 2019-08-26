package passmanager;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class App {

    static Scanner sc = new Scanner(System.in);

    static List<PasswordEntry> passwordEntries;
    static Map<String, PasswordEntry> passwordEntryMap;

    public static void main(String[] args) throws IOException {

        passwordEntries = FileManager.readFromFile();

        passwordEntryMap = passwordEntries.stream()
                .collect(Collectors.toMap(PasswordEntry::getSiteName, Function.identity()));

        while (true) {
            System.out.println("Co chcesz zrobić?\n1. Dodaj nowe hasło.\n2. Odczytaj hasło.\n3. Zaktualizuj hasło.\n4. Usuń hasło.\n 0. Wyjdź");
            String input = sc.nextLine();
            if (input.equals("1")) {
                addPasswordEntry();
            } else if (input.equals("2")) {
                readPasswordEntry();
            } else if (input.equals("3")) {
                updatePasswordEntry();
            } else if (input.equals("4")) {
                deletePasswordEntry();
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
        passwordEntryMap.put(siteName,passwordEntry);
    }

    public static void readPasswordEntry() {
        System.out.println("Podaj nazwę strony:");
        String siteName = sc.nextLine();
        System.out.println(passwordEntryMap.get(siteName).getPasswordEncrypted());
    }

    public static void updatePasswordEntry() {
        System.out.println("Podaj nazwę strony:");
        String siteName = sc.nextLine();
        System.out.println("Podaj nowe hasło");
        String newPassword = sc.nextLine();
        passwordEntryMap.get(siteName).setPasswordEncrypted(newPassword);
    }

    public static void deletePasswordEntry() {
        System.out.println("Podaj nazwę strony:");
        String siteName = sc.nextLine();
        passwordEntryMap.remove(siteName);
    }

}