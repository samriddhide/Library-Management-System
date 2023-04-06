package com.xfactor.openlibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xfactor.openlibrary.domain.Admin;
import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    List<Admin> findByName(String name);
    List<Admin> findByUsername(String username);
    List<Admin> findByPassword(String password);
}
