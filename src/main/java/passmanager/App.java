package passmanager;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App {

    static Scanner sc = new Scanner(System.in);

    static List<PasswordEntry> passwordEntries;
    static Map<String, PasswordEntry> passwordEntryMap;

    public static void main(String[] args) throws IOException {

        passwordEntries = FileManager.readFromFile();

        passwordEntryMap = passwordEntries.stream()
                .collect(Collectors.toMap(PasswordEntry::getSiteName, Function.identity()));

        while (true) {
            System.out.println("Co chcesz zrobić?\n1. Dodaj nowe hasło.\n2. Odczytaj hasło.\n3. Zaktualizuj hasło." +
                    "\n4. Usuń hasło.\n5. Wyświetl strony.\n0. Wyjdź");
            String input = sc.nextLine();
            if (input.equals("1")) {
                addPasswordEntry();
            } else if (input.equals("2")) {
                readPasswordEntry();
            } else if (input.equals("3")) {
                updatePasswordEntry();
            } else if (input.equals("4")) {
                deletePasswordEntry();
            }else if (input.equals("5")) {
                showAll();
            } else if (input.equals("0") || input.equalsIgnoreCase("exit")) {
                saveBeforeExit();
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
        System.out.println("Podaj hasło: (Jeśli chcesz wygenerować losowe hasło wybierz 9)");
        String passwordEncrypted = sc.nextLine();
        if (passwordEncrypted.equals("9")) {
            PasswordMedium pm = new PasswordMedium();
            passwordEncrypted = pm.generate();
            System.out.println(passwordEncrypted);
        }
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
        System.out.println("Podaj nowe hasło: (Jeśli chcesz wygenerować losowe hasło wybierz 9)");
        String newPassword = sc.nextLine();
        if (newPassword.equals("9")) {
            PasswordMedium pm = new PasswordMedium();
            newPassword = pm.generate();
            System.out.println(newPassword);
        }
        passwordEntryMap.get(siteName).setPasswordEncrypted(newPassword);
    }

    public static void deletePasswordEntry() {
        System.out.println("Podaj nazwę strony:");
        String siteName = sc.nextLine();
        passwordEntryMap.remove(siteName);
    }

    public static void showAll() {
        for (String keys : passwordEntryMap.keySet())
        {
            System.out.println(keys);
        }
    }

    public static void saveBeforeExit() throws IOException {
        List<PasswordEntry> listToSave = new ArrayList<>(passwordEntryMap.values());
        FileManager.saveToFile(listToSave);
    }

}