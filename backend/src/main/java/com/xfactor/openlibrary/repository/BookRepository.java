package com.xfactor.openlibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xfactor.openlibrary.domain.Book;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long>{

    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByIsbn(String isbn);
    List<Book> findByPublicationDate(String publicationDate);
    List<Book> findByPublisher(String publisher);
    List<Book> findByCopies(int copies);
    List<Book> findByCategory(String category);
    List<Book> findByGenre(String genre);
    List<Book> findBySubgenre(String subgenre);
}
