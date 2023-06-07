package org.skillgrowth.saranya_java_web_final_project.controller;

import org.skillgrowth.saranya_java_web_final_project.model.Book;
import org.skillgrowth.saranya_java_web_final_project.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @GetMapping("/{bookId}")
    public Book getBookId(@PathVariable Integer bookId){
        return bookService.getBookById(bookId);
    }
    @PutMapping("/{bookId}")
    public void updateBook(@PathVariable Integer bookId, @RequestBody Book book){
        bookService.updateBook(bookId, book);
    }
    @DeleteMapping("/{bookId}")
    public void deleteById(@PathVariable Integer bookId){
        bookService.deleteById(bookId);
    }

}
