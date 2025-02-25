package com.productstore.resources;

import com.productstore.entities.Order;
import com.productstore.services.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@Tag(name = "Orders", description = "Operations related to Oder management")
@RequestMapping(value ="/orders")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping
    @Tag(name = "Find All Orders", description = "Retrieve all orders from the database")
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    @Tag(name = "Find Order by ID", description = "Retrieve a specific order by their ID")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order obj = orderService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
