package com.javalearners.libraryapp.model;
import java.util.Optional;

public class Book {

    private String title;
    private String author;
    private int publicationYear;
    private int ISBN;
    private int bookID;
    private Optional<String> bookOwner;

    private Book(BookBuilder bookBuilder){
        this.title = bookBuilder.title;
        this.author = bookBuilder.author;
        this.publicationYear = bookBuilder.publicationYear;
        this.ISBN = bookBuilder.ISBN;
        this.bookID = bookBuilder.bookID;
        this.bookOwner = bookBuilder.bookOwner;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getPublicationYear() { return publicationYear; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }

    public int getISBN() { return ISBN; }
    public void setISBN(int ISBN) { this.ISBN = ISBN; }

    public int getBookID() { return bookID; }

    public Optional<String> getBookOwner() { return bookOwner; }
    public void setBookOwner(String bookOwner) { this.bookOwner = Optional.of(bookOwner); }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Title: " + this.title)
                .append("Author: " + this.author)
                .append("Publication Year: " + this.publicationYear)
                .append("ISBN: " + this.ISBN)
                .append("Book ID:" + this.bookID)
                .append("Book Owner: " + this.bookOwner.toString());
        return stringBuilder.toString();
    }

    public static class BookBuilder {
        private String title;
        private String author;
        private int publicationYear;
        private int ISBN;
        private int bookID;
        private Optional<String> bookOwner;

        public BookBuilder(String title) {
            this.title = title; //setting title here because title should be mandatory
            this.bookID = 0; // need to generate bookID automatically
            this.bookOwner = Optional.empty();
        }

        public BookBuilder author(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder publicationYear(int publicationYear) {
            this.publicationYear = publicationYear;
            return this;
        }

        public BookBuilder ISBN(int ISBN) {
            this.ISBN = ISBN;
            return this;
        }

        public Book build() {
            Book book = new Book(this);
            //validateBook(book);
            return book;
        }

        // IMPLEMENT LATER
        //private void validateBook(Book book){};
    }
}