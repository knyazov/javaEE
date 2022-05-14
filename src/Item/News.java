package Item;

public class News {
    private String header;
    private String content;
    private String author;
    private String type;

    public News() {
    }

    public News(String header, String content, String author, String type) {
        this.header = header;
        this.content = content;
        this.author = author;
        this.type = type;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
