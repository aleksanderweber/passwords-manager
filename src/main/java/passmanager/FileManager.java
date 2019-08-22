package passmanager;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FileManager {

    public static void saveToFile(List<PasswordEntry> passwordEntries) throws IOException {
        CSVWriter writer = new CSVWriter(
                new FileWriter("passwords.csv"),
                ';',
                '"',
                '\\',
                "\n");

        writer.writeAll(passwordEntries.stream()
                .map(FileManager::passwordEntryToArray)
                .peek(passwordEntry -> System.out.println(Arrays.toString(passwordEntry)))
                .peek(System.out::println)
                .collect(toList())
        );
        writer.close();
    }

//    public static List<PasswordEntry> readFromFile() throws FileNotFoundException {
//        CSVReader reader = new CSVReader(
//                new FileReader("passwords.csv"),
//
//        );
//
//    }

    public static String[] passwordEntryToArray(PasswordEntry passwordEntry) {
        return new String[]{
          String.valueOf(passwordEntry.getId()),
          passwordEntry.getPasswordEncrypted(),
          passwordEntry.getSiteName(),
          passwordEntry.getLogin(),
          passwordEntry.getDescription()};
    }

    public static PasswordEntry arrayToPasswordEntry(String[] row){
        int id = Integer.parseInt(row[0]);
        String passwordEncrypted = row[1];
        String siteName = row[2];
        String login = row[3];
        String description = row[4];
        return new PasswordEntry(id, passwordEncrypted, siteName, login, description);
    }


}
