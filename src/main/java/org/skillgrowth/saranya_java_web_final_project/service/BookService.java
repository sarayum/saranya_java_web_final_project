package org.skillgrowth.saranya_java_web_final_project.service;

import org.skillgrowth.saranya_java_web_final_project.model.Book;
import org.skillgrowth.saranya_java_web_final_project.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Integer bookId){
        return bookRepository.findById(bookId).orElse(null);
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void deleteById(Integer bookId){
        bookRepository.deleteById(bookId);
    }

    public void updateBook(Integer bookId, Book book){
        Book update = bookRepository.findById(bookId).orElseThrow();
        update.setBookTitle(book.getBookTitle());
        update.setCheckoutDate(book.getCheckoutDate());
        update.setCheckoutBy(book.getCheckoutBy());
        update.setDueDate(book.getDueDate());
        bookRepository.save(update);
    }
}
