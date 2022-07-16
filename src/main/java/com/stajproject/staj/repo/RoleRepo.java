package com.stajproject.staj.repo;

import com.stajproject.staj.ENUM.ERole;
import com.stajproject.staj.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);
}
