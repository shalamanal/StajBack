package com.stajproject.staj.service;

import com.stajproject.staj.exeption.NotFoundException;
import com.stajproject.staj.model.Orders;
import com.stajproject.staj.repo.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class OrdersService {
    private final OrdersRepo ordersRepo;
    @Autowired
    public OrdersService(OrdersRepo ordersRepo) {
        this.ordersRepo = ordersRepo;
    }
    public List<Orders> findAllOrders(){
        return ordersRepo.findAll();
    }

    public Orders updateOrders(Orders orders){
        return ordersRepo.save(orders);
    }

    public Orders findOrdersByOrdersId(Long orderId) throws Throwable {
        return ordersRepo.findOrdersByOrderId(orderId)
                .orElseThrow(() -> new NotFoundException("Order by id " + orderId + " not found"));
    }

    public List<Orders> findOrdersByUsersId(Long id){
        return ordersRepo.findOrdersByUsersId(id);
    }
    @Transactional
    public Orders addOrder(Orders order){
        return ordersRepo.saveAndFlush(order);
    }
    @Transactional
    public void deleteOrders(Long id){
        ordersRepo.deleteOrdersByOrderId(id);
    }
}
