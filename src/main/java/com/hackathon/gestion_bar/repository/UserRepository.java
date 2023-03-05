package com.hackathon.gestion_bar.repository;

import com.hackathon.gestion_bar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByIdUser(Long id);

    @Query("SELECT u FROM User u")
    List<User> allUserInformation();

    List<User> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrRoleContainingIgnoreCase(String firstName, String lastName, String role);
}
