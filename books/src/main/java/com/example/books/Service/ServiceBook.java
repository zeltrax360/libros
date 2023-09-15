package com.example.books.Service;

import com.example.books.Model.BookRequest;
import com.example.books.Persintence.Entity.Book;

public interface ServiceBook {

    Book saveBook(BookRequest book);

    Book getBookById(Integer idBook);

    Book getBookBytittle(String title);

    Book getBookByauthor(String author);

    Book bookUpdate(Integer id, BookRequest bookUpdate);



    boolean deleteBook(Integer id);

}
