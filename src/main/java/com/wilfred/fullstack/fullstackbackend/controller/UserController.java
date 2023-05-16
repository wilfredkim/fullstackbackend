package com.wilfred.fullstack.fullstackbackend.controller;

import com.wilfred.fullstack.fullstackbackend.exception.UserNotFoundException;
import com.wilfred.fullstack.fullstackbackend.models.User;
import com.wilfred.fullstack.fullstackbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class UserController {

    private final UserRepository userRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<User> getList() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    User findById(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User updateUser(@RequestBody User user, @PathVariable Long id) {
        User userToUpdate = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        if (user.getName() != null)
            userToUpdate.setName(user.getName());
        if (user.getUsername() != null)
            userToUpdate.setUsername(user.getUsername());
        if (user.getEmailAddress() != null)
            userToUpdate.setEmailAddress(user.getEmailAddress());
        return userRepository.save(userToUpdate);


    }

    @DeleteMapping
    public String deleteUser(@RequestBody User user) {
        try {
            userRepository.delete(user);
            return "Successfully deleted!";
        } catch (Exception e) {
            return "An error occurred " + e.getLocalizedMessage();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteById(@PathVariable Long id) {
        try {
            User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
            userRepository.deleteById(user.getId());
            return "Successfully deleted!";

        } catch (Exception e) {
            return "An error occurred " + e.getLocalizedMessage();

        }
    }
}
