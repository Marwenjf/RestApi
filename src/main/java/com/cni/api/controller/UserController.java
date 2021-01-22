package com.cni.api.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cni.api.model.User;
import com.cni.api.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
@Validated
public class UserController {
	
	@Autowired
	UserRepository userRepository; 
	
	@GetMapping(value="/users")
    List<User> getAll(){
        return userRepository.findAll();
    }
	
	@GetMapping(value="/users/inactive")
    List<User> getAllInActive(){
        return userRepository.findAllInActiveUsers();
    }
	@GetMapping(value="/users/active")
    List<User> getAllActive(){
        return userRepository.findAllActiveUsers();
    }
	
    @GetMapping(value="/users/{mat}")
    ResponseEntity<User> getById(@PathVariable("mat") Long mat) {
        User usr = userRepository.findById(mat).orElseThrow();
        return ResponseEntity.ok().body(usr);
    }
    
    @PostMapping(value="/users")
    ResponseEntity<User> create(User user) {
        
        User addeduser = userRepository.save(user);
        
        return ResponseEntity.ok().body(addeduser);
    }
    @PutMapping(value="/users/{mat}")
    ResponseEntity<User> update(@PathVariable("mat")  Long mat,  @RequestBody User user) {

        User puser = userRepository.findById(mat)
                .orElseThrow();
        
        user.setMat(puser.getMat());
        userRepository.save(user);
        return ResponseEntity.ok().body(user);
        
    }
    @DeleteMapping(value="/users/{mat}")
    ResponseEntity<String> delete(@PathVariable("mat") Long mat) {
        User user = userRepository.findById(mat)
                .orElseThrow();
        
        userRepository.deleteById(user.getMat());
        return ResponseEntity.ok().body("User deleted with success!");      
    }
}
