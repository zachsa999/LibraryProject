package com.javalearners.libraryapp.model;

public class Book {

    private String title;
    private String author;
    private int publicationYear;
    private boolean checkedOut;
    private int bookId;
    private String bookOwner;
    private int ISBN;



    public Book(
            String title, String author, int publicationYear,
            boolean checkedOut, int bookId, String bookOwner, int ISBN) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.checkedOut = checkedOut;
        this.bookId = bookId;
        this.bookOwner = bookOwner;
        this.ISBN = ISBN;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public boolean getCheckedOut(boolean checkedOut) {
        return this.checkedOut = checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public static class Builder {
        private String title;
        private String author;
        private int publicationYear;
        private boolean checkedOut;
        private int bookId;
        private String bookOwner;
        private int ISBN;

        public Builder() {

        }

        public Builder theTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder theAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder thePublicationYear(int publicationYear) {
            this.publicationYear = publicationYear;
            return this;
        }

        public Builder theCheckedOut(boolean checkedOut) {
            this.checkedOut = checkedOut;
            return this;
        }

        public Builder theBookId(int bookId) {
            this.bookId = bookId;
            return this;
        }

        public Builder theBookOwner(String bookOwner) {
            this.bookOwner = bookOwner;
            return this;
        }

        public Builder theISBN(int ISBN) {
            this.ISBN = ISBN;
            return this;
        }

        public Book build() {
            return new Book(title, author, publicationYear, checkedOut, bookId, bookOwner, ISBN);
        }
    }




    @Override
    public String toString() {
        return
                "Title : '" + this.getTitle() + "', Author: '" + this.getAuthor()
                        + "', Publication Year: '" + this.getPublicationYear() +
                        "', Is it checked out: '" + this.getCheckedOut(false) +
                        "', BookID: '" + this.bookId + "', Book Owner: '" +
                        this.bookOwner + "', ISBN: '" + this.ISBN + "'";
    }
    public static void main(String[] args) {
        Book book1 = new Book.Builder()
                .theTitle("Start with Why")
                .theAuthor("Mike")
                .thePublicationYear(1999)
                .theCheckedOut(true)
                .theBookId(3424)
                .theBookOwner("Islam")
                .theISBN(4234)
                .build();


        System.out.println(book1.toString());
    }

}