package ru.skypro.homework.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.springsecurity.pojo.AuthUser;

public interface UserRepository extends JpaRepository<AuthUser, Long> {
    AuthUser findByUsername(String username);
}
