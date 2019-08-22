package passmanager;

public class PasswordEntry {
    private int id;
    private String passwordEncrypted;
    private String siteName;
    private String login;
    private String description;


    public PasswordEntry(int id, String passwordEncrypted, String siteName, String login, String description) {
        this.id = id;
        this.passwordEncrypted = passwordEncrypted;
        this.siteName = siteName;
        this.login = login;
        this.description = description;
    }

    public void setPasswordEncrypted(String passwordEncrypted) {
        this.passwordEncrypted = passwordEncrypted;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getPasswordEncrypted() {
        return passwordEncrypted;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getLogin() {
        return login;
    }

    public String getDescription() {
        return description;
    }
}