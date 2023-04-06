package com.xfactor.openlibrary.controllers;

import com.xfactor.openlibrary.domain.Publisher;

// import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xfactor.openlibrary.repository.PublisherRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;



import java.util.List;
import java.util.Optional;
//import java.util.HashMap;

@RestController
@RequestMapping("publisher")
public class PublisherController {
    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    //ArrayList<Publisher> lpublisher = new ArrayList<>();
    private PublisherRepository publisherRepository;

    @PostMapping("/savepublisher")
    public Publisher saveBook(@RequestBody Publisher publisher) {
        publisherRepository.save(publisher);
        return publisher;
    }

    @GetMapping("/getAll")
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    // get publisher by id
    @GetMapping("/getPublisherById")
    public Publisher findById(@PathVariable long id) {
        Optional<Publisher> optionalofPublisher = publisherRepository.findById(id);
        if (optionalofPublisher.isPresent()) {
            return optionalofPublisher.get();
        }
        return null;
    }

    // get publisher by name
    @GetMapping("/getPublisherByName/{name}")
    public List<Publisher> findByName(@PathVariable String name) {
        List<Publisher> optionalofPublisher = publisherRepository.findByName(name);
        return optionalofPublisher;
    }

    // get publisher by Address
    @GetMapping("/getPublisherByAddress/{address}")
    public List<Publisher> findByAddress(@PathVariable String address) {
        List<Publisher> optionalofPublisher = publisherRepository.findByAddress(address);
        return optionalofPublisher;
    }

    // get publisher by Phone
    @GetMapping("/getPublisherByPhone/{phone}")
    public List<Publisher> findByPhone(@PathVariable String phone) {
        List<Publisher> optionalofPublisher = publisherRepository.findByPhone(phone);
        return optionalofPublisher;
    }

    // get publisher by Email
    @GetMapping("/getPublisherByEmail/{email}")
    public List<Publisher> findByEmail(@PathVariable String email) {
        List<Publisher> optionalofPublisher = publisherRepository.findByEmail(email);
        return optionalofPublisher;
    }

    // update publisher
    @PutMapping("/updatePublisher")
    public Publisher updatePublisher(@RequestBody Publisher publisher) {
        if (publisher.getId() != 0L) {
            Publisher publisher2 = publisherRepository.save(publisher);
            return publisher2;
        }
        return null;
    }

    // delete publisher
    @DeleteMapping("/delete/{id}")
    public void deletePublisher(@PathVariable Long id) {
        publisherRepository.deleteById(id);
    }




}
