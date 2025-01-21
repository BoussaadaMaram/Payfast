package com.paymentqrcode.controller;

import com.mongodb.client.MongoIterable;
import com.paymentqrcode.model.User;
import com.paymentqrcode.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User registeredUser = authService.register(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<User> authenticate(@RequestBody User user) {
        Optional<User> authenticatedUser = authService.authenticate(user.getUsername(), user.getPassword());
        return authenticatedUser.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).build()); // Unauthorized if authentication fails
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(authService.getAllUsers());
    }

    // Mise à jour de cette méthode pour accepter l'ID en String
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {  // L'ID est de type String
        Optional<User> user = authService.getUserById(id);  // Cela retourne un Optional<User>
        return user.map(ResponseEntity::ok)  // Si l'utilisateur existe, retourne 200 OK
                .orElse(ResponseEntity.notFound().build());  // Sinon, retourne 404 Not Found
    }



    // Mise à jour de cette méthode pour accepter l'ID en String
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User updatedUser) {  // Changer Long en String
        User user = authService.updateUser(id, updatedUser);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {  // Changer Long en String
        authService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
