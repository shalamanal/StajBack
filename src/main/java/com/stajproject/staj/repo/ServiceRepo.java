package com.stajproject.staj.repo;

import com.stajproject.staj.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceRepo extends JpaRepository<Service, Long> {
    Optional<Service> findServiceById(Long id);

    void deleteServiceById(Long id);
}
