package com.stajproject.staj.controller;

import com.stajproject.staj.model.Orders;
import com.stajproject.staj.service.OrdersService;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrdersController {
    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<List<Orders>> getAllOrders(){
        List<Orders> orders = ordersService.findAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<Orders> getOrderById(@PathVariable("id") Long id) throws Throwable {
        Orders order = ordersService.findOrdersByOrdersId(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Orders> addOrder(@RequestBody Orders order){
            Orders newOrder = ordersService.addOrder(order);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Orders> updateOrder(@RequestBody Orders order){
        Orders updateOrder = ordersService.updateOrders(order);
        return new ResponseEntity<>(updateOrder, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") Long id){
        ordersService.deleteOrders(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/findUserOrders/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('USER')")
    public ResponseEntity<List<Orders>> getOrdersByUserId(@PathVariable("id") Long id){
        List<Orders> orders = ordersService.findOrdersByUsersId(id);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
