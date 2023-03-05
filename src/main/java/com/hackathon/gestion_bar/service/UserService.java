package com.hackathon.gestion_bar.service;

import com.hackathon.gestion_bar.model.User;
import com.hackathon.gestion_bar.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository repository;

    public String insertUser(User user){
        repository.save(user);
        return "User inserted successfully";
    }

    public List<User> getAllUser(){
        return repository.findAll();
    }

    public Optional<User> getUserById(long id){
        return repository.findByIdUser(id);
    }

    public List<User> getUserByNameOrRole(String firstName, String lastName, String role){
        return repository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrRoleContainingIgnoreCase(firstName, lastName, role);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public void updateUser (Long id, String newName, String newRole){
        Optional<User> users = repository.findByIdUser(id);

        if(users.isPresent()){
            User user = users.get();
            user.setUsername(newName);
            user.setRole(newRole);
            repository.save(user);
        }else{
            throw new NullPointerException("User not found");
        }
    }
}
