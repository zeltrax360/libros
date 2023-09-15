package com.example.books.Persintence.Repository;

import com.example.books.Persintence.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryBook extends JpaRepository<Book, Integer> {

    Optional<Object> findByTitle(String title);

    Optional<Object> findByAuthor(String author);
}
