package com.paymentqrcode.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "users")  // Spécifie la collection MongoDB associée
@Data // Lombok génère automatiquement les getters, setters, toString(), etc.
@NoArgsConstructor  // Constructeur sans arguments pour MongoDB
public class User {
    @Id
    private String id;
    private String username;
    private String password;  // Le mot de passe sera haché
    private String firstName;
    private String lastName;
    private String token;
    private double balance;

    // Constructeur avec arguments
    public User(String username, String password, String firstName, String lastName,String token, double balance) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.token = token;
        this.balance = balance;
    }


}
