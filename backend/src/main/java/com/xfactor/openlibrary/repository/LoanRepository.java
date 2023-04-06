package com.xfactor.openlibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xfactor.openlibrary.domain.Loan;
import java.util.List;

public interface LoanRepository extends JpaRepository<Loan,Long> {
    List<Loan> findByBookId(int bookId);
    List<Loan> findByStudentId(int studentId);
    List<Loan> findByCheckoutDate(String checkoutDate);
    List<Loan> findByDueDate(String dueDate);
    List<Loan> findByReturnDate(String returnDate);

}
