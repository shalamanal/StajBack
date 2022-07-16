package com.stajproject.staj.repo;


import com.stajproject.staj.model.Orders;
import com.stajproject.staj.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrdersRepo extends JpaRepository<Orders, Long> {

    void deleteOrdersByOrderId(Long id);


    Optional<Orders> findOrdersByOrderId(Long id);

    List<Orders> findOrdersByUsersId(Long id);

    void deleteOrdersByUsersId(Long id);
}
