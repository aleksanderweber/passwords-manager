package passmanager;

import java.util.Random;

public class PasswordMedium implements PasswordGenerator {

    private static final String possibleChars = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random random = new Random();

    @Override
    public String generate() {
        StringBuilder generatedPassword = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            generatedPassword.append(possibleChars.charAt(random.nextInt(possibleChars.length())));
        }
        return generatedPassword.toString();


    }
}
