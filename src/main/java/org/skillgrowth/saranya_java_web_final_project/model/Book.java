package org.skillgrowth.saranya_java_web_final_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    private String bookTitle;
    private LocalDate checkoutDate;
    private String checkoutBy;
    private LocalDate dueDate;

    public Book(){

    }

    public Book(Integer bookId, String bookTitle, LocalDate checkoutDate, String checkoutBy, LocalDate dueDate) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.checkoutDate = checkoutDate;
        this.checkoutBy = checkoutBy;
        this.dueDate = dueDate;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getCheckoutBy() {
        return checkoutBy;
    }

    public void setCheckoutBy(String checkoutBy) {
        this.checkoutBy = checkoutBy;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(getBookId(), book.getBookId()) && Objects.equals(getBookTitle(), book.getBookTitle()) && Objects.equals(getCheckoutDate(), book.getCheckoutDate()) && Objects.equals(getCheckoutBy(), book.getCheckoutBy()) && Objects.equals(getDueDate(), book.getDueDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getBookTitle(), getCheckoutDate(), getCheckoutBy(), getDueDate());
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", checkoutDate=" + checkoutDate +
                ", checkoutBy='" + checkoutBy + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }
}
