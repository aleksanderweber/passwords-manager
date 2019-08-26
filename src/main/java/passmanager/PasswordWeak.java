package passmanager;

public class PasswordWeak implements PasswordGenerator {

    private static final String possibleChars = "abcdefghijklmnopqrstuvwxyz0123456789";

    @Override
    public String generate() {
        StringBuilder generatedPassword = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            generatedPassword.append(possibleChars.charAt((int) (Math.random() * possibleChars.length())));
        }
        return generatedPassword.toString();
    }
}
