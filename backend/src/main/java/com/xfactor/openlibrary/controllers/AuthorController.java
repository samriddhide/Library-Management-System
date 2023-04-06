package com.xfactor.openlibrary.controllers;

import com.xfactor.openlibrary.domain.Author;

// import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xfactor.openlibrary.repository.AuthorRepository;
//import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

import java.util.List;
//import java.util.HashMap;

@RestController
@RequestMapping("author")
public class AuthorController{
    //ArrayList<Author> lauthor=new ArrayList<>();
    private AuthorRepository authorRepository;
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping("/saveauthor")
    public Author saveAuthor(@RequestBody Author author){
        authorRepository.save(author);
        return author;
    }

    @GetMapping("/getAll")
    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    // get author by id
    @GetMapping("/getAuthorById")
    public Author findById(@PathVariable long id) {
        Optional<Author> optionalofAuthor = authorRepository.findById(id);
        if (optionalofAuthor.isPresent()) {
            return optionalofAuthor.get();
        }
        return null;
    }

    // get author by name
    @GetMapping("/getAuthorByName/{name}")
    public List<Author> findByName(@PathVariable String name) {
        List<Author> optionalofAuthor = authorRepository.findByName(name);
        return optionalofAuthor;
    }

    // get author by birthDate
    @GetMapping("/getAuthorByBirthDate/{birthDate}")
    public List<Author> findByBirthdate(@PathVariable String birthDate) {
        List<Author> optionalofAuthor = authorRepository.findByBirthDate(birthDate);
        return optionalofAuthor;
    }

    // get author by nationality
    @GetMapping("/getAuthorByNationality/{nationality}")
    public List<Author> findByNationality(@PathVariable String nationality) {
        List<Author> optionalofAuthor = authorRepository.findByNationality(nationality);
        return optionalofAuthor;
    }
    
    // update author
    @PutMapping("/updateAuthor")
    public Author updateAuthor(@RequestBody Author author) {
        if (author.getId() != 0L) {
            Author author2 = authorRepository.save(author);
            return author2;
        }
        return null;
    }

    // delete author
    @DeleteMapping("/delete/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorRepository.deleteById(id);
    }
}
