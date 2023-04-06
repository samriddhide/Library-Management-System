package com.xfactor.openlibrary.controllers;
import com.xfactor.openlibrary.domain.Book;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;

// import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xfactor.openlibrary.repository.BookRepository;

import java.util.List;
//import java.util.HashMap;
import java.util.Optional;

//import javax.validation.constraints.Null;

@RestController
@RequestMapping("books")
public class BooksController {
    public BooksController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //ArrayList<Book> lBooks=new ArrayList<>();
    private BookRepository bookRepository;
    @PostMapping("/savebook")
    public Book saveBook(@RequestBody Book book){
        bookRepository.save(book);
        return book;
    }

    @GetMapping("/getAll")
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    //get book by id
    @GetMapping("/getBookById")
    public Book findById(@PathVariable long id){
        Optional<Book> optionalofBook=bookRepository.findById(id);
        if(optionalofBook.isPresent()){
            return optionalofBook.get();
        }
        return null;
    }

    //get book by title
    @GetMapping("/getBookByTitle/{title}")
    public List<Book> findByTitle(@PathVariable String title){
        List<Book> optionalofBook=bookRepository.findByTitle(title);
        return optionalofBook;
    }

    //get book by author
    @GetMapping("/getBookByAuthor/{author}")
    public List<Book> findByAuthor(@PathVariable String author){
        List<Book> optionalofBook=bookRepository.findByAuthor(author);
        return optionalofBook;
    }

    //get book by isbn
    @GetMapping("/getBookByIsbn/{isbn}")
    public List<Book> findByIsbn(@PathVariable String isbn) {
        List<Book> optionalofBook = bookRepository.findByIsbn(isbn);
        return optionalofBook;
    }

    //find by publication date
    @GetMapping("/getBookByPublicationDate/{publicationDate}")
    public List<Book> findByPublicationDate(@PathVariable String publicationDate) {
        List<Book> optionalofBook = bookRepository.findByPublicationDate(publicationDate);
        return optionalofBook;
    }

    //find by publisher
    @GetMapping("/getBookByPublisher/{publisher}")
    public List<Book> findByPublisher(@PathVariable String publisher) {
        List<Book> optionalofBook = bookRepository.findByPublisher(publisher);
        return optionalofBook;
    }

    //find by copies
    @GetMapping("/getBookByCopies/{copies}")
    public List<Book> findByCopies(@PathVariable int copies) {
        List<Book> optionalofBook = bookRepository.findByCopies(copies);
        return optionalofBook;
    }

    //find by category
    @GetMapping("/getBookByCategory/{category}")
    public List<Book> findByCategory(@PathVariable String category) {
        List<Book> optionalofBook = bookRepository.findByCategory(category);
        return optionalofBook;
    }

    //find by genre
    @GetMapping("/getBookByGenre/{genre}")
    public List<Book> findByGenre(@PathVariable String genre) {
        List<Book> optionalofBook = bookRepository.findByGenre(genre);
        return optionalofBook;
    }

    //find by sub genre
    @GetMapping("/getBookBySubgenre/{subgenre}")
    public List<Book> findBySubgenre(@PathVariable String subgenre) {
        List<Book> optionalofBook = bookRepository.findBySubgenre(subgenre);
        return optionalofBook;
    }

    //update book
    @PutMapping("/updateBook")
    public Book updateBook(@RequestBody Book book){
        if(book.getId()!=0L){
            Book book2=bookRepository.save(book);
            return book2;
        }
        return null;
    }

    //delete book
    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id){
        bookRepository.deleteById(id);
    }


}