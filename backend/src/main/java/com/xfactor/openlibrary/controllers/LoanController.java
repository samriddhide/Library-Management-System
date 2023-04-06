package com.xfactor.openlibrary.controllers;

import com.xfactor.openlibrary.domain.Loan;

// import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xfactor.openlibrary.repository.LoanRepository;
//import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
//import java.util.HashMap;

@RestController
@RequestMapping("loan")
public class LoanController {
    public LoanController(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    //ArrayList<Loan> lloan = new ArrayList<>();
    private LoanRepository loanRepository;
    @PostMapping("/saveloan")
    public Loan saveLoan(@RequestBody Loan loan) {
        loanRepository.save(loan);
        return loan;
    }

    @GetMapping("/getAll")
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    // get loan by id
    @GetMapping("/getLoanById")
    public Loan findById(@PathVariable long id) {
        Optional<Loan> optionalofLoan = loanRepository.findById(id);
        if (optionalofLoan.isPresent()) {
            return optionalofLoan.get();
        }
        return null;
    }

    // get loan by book id
    @GetMapping("/getLoanByBookId/{bookId}")
    public List<Loan> findByBookId(@PathVariable int bookId) {
        List<Loan> optionalofLoan = loanRepository.findByBookId(bookId);
        return optionalofLoan;
    }

    // get loan by student id
    @GetMapping("/getLoanBystudentId/{studentId}")
    public List<Loan> findByStudentId(@PathVariable int studentId) {
        List<Loan> optionalofLoan = loanRepository.findByStudentId(studentId);
        return optionalofLoan;
    }

    // get loan by checkout date
    @GetMapping("/getLoanBycheckoutDate/{checkoutDate}")
    public List<Loan> findByCheckoutDate(@PathVariable String checkoutDate) {
        List<Loan> optionalofLoan = loanRepository.findByCheckoutDate(checkoutDate);
        return optionalofLoan;
    }

    // get loan by due date
    @GetMapping("/getLoanBydueDate/{dueDate}")
    public List<Loan> findByDueDate(@PathVariable String dueDate) {
        List<Loan> optionalofLoan = loanRepository.findByDueDate(dueDate);
        return optionalofLoan;
    }

    // get loan by return date
    @GetMapping("/getLoanByReturnDate/{returnDate}")
    public List<Loan> findByReturnDate(@PathVariable String returnDate) {
        List<Loan> optionalofLoan = loanRepository.findByReturnDate(returnDate);
        return optionalofLoan;
    }

    // update loan
    @PutMapping("/updateLoan")
    public Loan updateLoan(@RequestBody Loan loan) {
        if (loan.getId() != 0L) {
            Loan loan2 = loanRepository.save(loan);
            return loan2;
        }
        return null;
    }

    // delete loan
    @DeleteMapping("/delete/{id}")
    public void deleteLoan(@PathVariable Long id) {
        loanRepository.deleteById(id);
    }


}
