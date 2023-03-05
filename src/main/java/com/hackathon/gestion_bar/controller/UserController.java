package com.hackathon.gestion_bar.controller;

import com.hackathon.gestion_bar.model.Drink;
import com.hackathon.gestion_bar.model.User;
import com.hackathon.gestion_bar.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
public class UserController {
    private UserService service;

    @CrossOrigin
    @GetMapping("/")
    public String helloWorld(){
        return "Hello world Spring Boot";
    }

    @CrossOrigin
    @GetMapping("/users")
    public List<User> allUser(
            @RequestParam(name = "last_name", required = false)String lastName,
            @RequestParam(name = "first_name", required = false)String firstName,
            @RequestParam(name = "role", required = false)String role
    ){
        if(lastName != null || firstName != null || role != null){
            return service.getUserByNameOrRole(firstName, lastName, role);
        }else{
            return service.getAllUser();
        }
    }

//    Get users by ID
    @CrossOrigin
    @GetMapping("/users/{id}")
    public Optional<User> getUsersById(@PathVariable Long id){
        return service.getUserById(id);
    }

    @CrossOrigin
    @PostMapping("/users")
    public String insertUser(@RequestBody User user){
        return service.insertUser(user);
    }

    @CrossOrigin
    @PatchMapping("/user")
    public void updateUser(
            @RequestParam(name = "id")Long id,
            @RequestParam(name = "new_Name", required = false)String newName,
            @RequestParam(name = "new_role", required = false)String newRole
    ){
        service.updateUser(id, newName, newRole);
    }

    @CrossOrigin
    @DeleteMapping("/users/{id}")
    public void deleteById(Long id){
        service.deleteById(id);
    }
}
