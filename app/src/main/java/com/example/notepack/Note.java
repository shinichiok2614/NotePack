package note;

public class Note {
    int id;
    String title;
    String data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Note(int id, String title, String data) {
        this.id = id;
        this.title = title;
        this.data = data;
    }
}
