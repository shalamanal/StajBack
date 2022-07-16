package com.stajproject.staj.repo;

import com.stajproject.staj.model.Machinery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MachineryRepo extends JpaRepository<Machinery, Long> {
    void deleteMachineryById(Long id);

    Optional<Machinery> findMachineryById(Long id);
}
