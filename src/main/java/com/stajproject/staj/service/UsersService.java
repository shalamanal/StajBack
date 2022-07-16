package com.stajproject.staj.service;


import com.stajproject.staj.exeption.NotFoundException;
import com.stajproject.staj.model.Users;
import com.stajproject.staj.repo.OrdersRepo;
import com.stajproject.staj.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class UsersService {
    private final UsersRepo usersRepo;
    private final OrdersRepo ordersRepo;
    @Autowired

    public UsersService(UsersRepo usersRepo, OrdersRepo ordersRepo) {
        this.usersRepo = usersRepo;
        this.ordersRepo = ordersRepo;
    }

    public List<Users> findAllUsers(){
        return usersRepo.findAll();
    }

    public Users updateUsers(Users users){
        return usersRepo.save(users);
    }

    public Users findUsersById(Long id) throws Throwable {
        return usersRepo.findUsersById(id)
                .orElseThrow(() -> new NotFoundException("User by id " + id + " not found"));
    }
    @Transactional
    public void deleteUsers(Long id){
        ordersRepo.deleteOrdersByUsersId(id);
        usersRepo.deleteUsersById(id);
    }
    @Transactional
    public Users addUsers(Users user) {
        return usersRepo.saveAndFlush(user);
    }



}
