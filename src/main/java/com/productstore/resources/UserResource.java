package com.productstore.resources;

import com.productstore.entities.User;
import com.productstore.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@Tag(name = "Users", description = "Operations related to User management")
@RequestMapping(value ="/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    @Tag(name = "Find All Users", description = "Retrieve all users from the database")
    public ResponseEntity<List<User>> findAll() {
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    @Tag(name = "Find User by ID", description = "Retrieve a specific user by their ID")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = userService.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    @Tag(name = "Create User", description = "Add a new user to the database")
    public ResponseEntity<User> insert(@RequestBody User obj) {
        obj = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    @Tag(name = "Delete User By Id", description = "Delete a specific user by their ID")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    @Tag(name = "Update User By Id", description = "Update details of an existing user by their ID")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
        obj = userService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
