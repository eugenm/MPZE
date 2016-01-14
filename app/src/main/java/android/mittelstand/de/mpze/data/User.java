package android.mittelstand.de.mpze.data;

public class User {
    private String name;
    private String notiz;

    public User(String name, String notiz) {
        this.name = name;
        this.notiz = notiz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotiz() {
        return notiz;
    }

    public void setNotiz(String notiz) {
        this.notiz = notiz;
    }

}
