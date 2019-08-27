package passmanager;

public class PasswordStrong implements PasswordGenerator{

    private static final String possibleChars = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public String generate() {

        StringBuilder generatedPassword = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            generatedPassword.append(possibleChars.charAt((int) (Math.random() * possibleChars.length())));
        }

        return generatedPassword.toString();
    }
}
