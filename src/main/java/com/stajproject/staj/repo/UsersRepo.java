package com.stajproject.staj.repo;

import com.stajproject.staj.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepo extends JpaRepository<Users, Long> {
    Optional<Users> findUsersById(Long id);

    Optional<Users> findByNickname(String nickname);

    Boolean existsByNickname(String nickname);

    void deleteUsersById(Long id);




}
