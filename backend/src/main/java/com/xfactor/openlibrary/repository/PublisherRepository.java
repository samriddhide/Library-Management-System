package com.xfactor.openlibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xfactor.openlibrary.domain.Publisher;
import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {
    List<Publisher> findByName(String name);
    List<Publisher> findByAddress(String address);
    List<Publisher> findByPhone(String phone);
    List<Publisher> findByEmail(String email);
}