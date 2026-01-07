package library;

public class Book {
    private String title;
    private String author;
    private Short year;
    private String genre;

    public Book(String title, String author, Short year, String genre) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Short getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }
}