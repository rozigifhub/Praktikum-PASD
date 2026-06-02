package Pertemuan15;

public class Book23 {
    public String isbn;
    public String title;

    public Book23() {
    }

    public Book23(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    @Override
    public String toString() {
        return "ISBN: " + this.isbn + " Title: " + this.title;
    }
}
