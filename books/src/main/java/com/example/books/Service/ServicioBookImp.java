package com.example.books.Service;

import com.example.books.Model.BookRequest;
import com.example.books.Persintence.Entity.Book;
import com.example.books.Persintence.Repository.RepositoryBook;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class ServicioBookImp implements ServiceBook {

    private  final RepositoryBook repositoryBook;

    @Override
    public Book saveBook(BookRequest bookRequest) {
        Book book = new Book(bookRequest.getId(), bookRequest.getTitle(), bookRequest.getAuthor(), bookRequest.getIbsn(), bookRequest.getPublishedDate());
        return repositoryBook.save(book);
    }

    @Override
    public Book getBookById(Integer idBook) {
        return repositoryBook.findById(idBook).orElseThrow(()-> {throw new RuntimeException("Book not found");});

    }

    @Override
    public Book getBookBytittle(String title) {
        return (Book) repositoryBook.findByTitle(title).orElseThrow(()-> {throw new RuntimeException("Book not found");});
    }



    @Override
    public Book getBookByauthor(String author) {
        return (Book) repositoryBook.findByAuthor(author).orElseThrow(()-> {throw new RuntimeException("Book not found");});
    }



    @Override
    public Book bookUpdate(Integer id, BookRequest bookUpdate) {
        Book bookSearch = repositoryBook.findById(id).get();
        bookSearch.setTitle(bookUpdate.getTitle());
        bookSearch.setAuthor(bookUpdate.getAuthor());


        repositoryBook.save(bookSearch);
        return repositoryBook.save(bookSearch);
    }

    @Override
    public boolean deleteBook(Integer id) {
        try {
            repositoryBook.deleteById(id);
            return true;

        }catch (Exception e){
            return false;
        }
    }
}
