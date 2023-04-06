package com.xfactor.openlibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xfactor.openlibrary.domain.Student;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByName(String name);
    List<Student> findByDepartment(String department);
    List<Student> findByRollNumber(String rollNumber);
    List<Student> findByBirthDate(String birthDate);
    List<Student> findByMobileNumber(String mobileNumber);

    
}
