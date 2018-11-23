package ru.mukhametzyanov;

public class Book {
    private String nameBook;
    private String author;
    private int year;
    private String contentsOfTheBook;

    public Book() {
    }

    public Book(String nameBook, String author, int year, String contentsOfTheBook) {
        this.nameBook = nameBook;
        this.author = author;
        this.year = year;
        this.contentsOfTheBook = contentsOfTheBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getContentsOfTheBook() {
        return contentsOfTheBook;
    }

    public void setContentsOfTheBook(String contentsOfTheBook) {
        this.contentsOfTheBook = contentsOfTheBook;
    }

    @Override
    public String toString() {
        return "Название книги = " + nameBook +
                ", Автор='" + author +
                ", Год издания=" + year +
                ", Содержание='" + contentsOfTheBook;
    }
}