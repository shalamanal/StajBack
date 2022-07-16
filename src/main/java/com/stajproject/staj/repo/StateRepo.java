package com.stajproject.staj.repo;

import com.stajproject.staj.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StateRepo extends JpaRepository<State, Long> {

    Optional<State> findStateById(Long id);

    void deleteStateById(Long id);
}
