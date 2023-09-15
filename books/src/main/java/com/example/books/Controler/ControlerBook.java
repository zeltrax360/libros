package com.example.books.Controler;

import com.example.books.Model.BookRequest;
import com.example.books.Service.ServiceBook;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class ControlerBook {

    private final ServiceBook serviceBook;

    @PostMapping // crear
    public ResponseEntity saveBook(@RequestBody BookRequest bookRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceBook.saveBook(bookRequest));
    }

    @GetMapping("/{id}") //obtener id
    public ResponseEntity getBookById(@PathVariable("id") Integer idBook) {
        return new ResponseEntity(serviceBook.getBookById(idBook), HttpStatus.OK);
    }

    @GetMapping("/title/{title}") //obtener titulo
    public ResponseEntity getBookBytittle(@PathVariable("title") String title) {
        return new ResponseEntity(serviceBook.getBookBytittle(title), HttpStatus.OK);
    }
    @GetMapping("/author/{author}") //obtener autor
    public ResponseEntity getBookByauthor(@PathVariable("author") String author) {
        return new ResponseEntity(serviceBook.getBookByauthor(author), HttpStatus.OK);
    }

    @PutMapping("/{id}") //actualizar
    public ResponseEntity bookUpdate(@PathVariable("id") Integer idBook, @RequestBody BookRequest bookRequest) {
        return new ResponseEntity(serviceBook.bookUpdate(idBook, bookRequest), HttpStatus.OK);}

    @DeleteMapping("/{id}")
        public ResponseEntity deleteBook(@PathVariable("id") Integer idBook) {
            boolean delete = serviceBook.deleteBook(idBook);
            if (delete) {
                return new ResponseEntity(HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }

    }
}