package com.stajproject.staj.controller;

import com.stajproject.staj.model.Orders;
import com.stajproject.staj.model.Users;
import com.stajproject.staj.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }
    @CrossOrigin
    @GetMapping("/all")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<List<Users>> getAllUsers(){
        List<Users> users = usersService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/find/{id}")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<Users> getUserById(@PathVariable("id") Long id) throws Throwable {
        Users user = usersService.findUsersById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(path = "/add", produces = "application/json")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<Users> addUser(@RequestBody Users user){
        Users newUser = usersService.addUsers(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @CrossOrigin
    @PutMapping("/update")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<Users> updateUser(@RequestBody Users user){
        Users updateUser = usersService.updateUsers(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        usersService.deleteUsers(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
   // @GetMapping("/orders")
   // public ResponseEntity<List<Orders>> getUserOrders(){
   //     List<Orders> userOrders = usersService.
   //     return new ResponseEntity<>(userOrders, HttpStatus.OK);
   // }
}
