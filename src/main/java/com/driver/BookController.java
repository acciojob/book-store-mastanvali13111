package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity findBookById(@PathVariable("id") String id){
        return new ResponseEntity<>(bookService.findBookById(id),HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity deleteBookById(@PathVariable("id") String id){
        bookService.deleteBookById(id);
        return new ResponseEntity<>("success",HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-all-books")
    public ResponseEntity findAllBooks(){
        return new ResponseEntity<>(bookService.findAllBooks(),HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-all-books")
    public ResponseEntity deleteAllBooks(){
        bookService.deleteAllBooks();
        return new ResponseEntity<>("success",HttpStatus.ACCEPTED);
    }

    @GetMapping("get-books-by-author")
    public ResponseEntity findBooksByAuthor(@RequestParam("author") String author){
        return new ResponseEntity<>(bookService.findBooksByAuthor(author),HttpStatus.FOUND);
    }

    @GetMapping("get-books-by-genre")
    public ResponseEntity findBooksByGenre(@RequestParam("genre") String genre){
        return new ResponseEntity<>(bookService.findBooksByGenre(genre),HttpStatus.FOUND);
    }
}