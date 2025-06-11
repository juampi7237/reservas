package com.reservas.reservas.infrastructure.adapters.web;

import com.reservas.reservas.domain.model.User;
import com.reservas.reservas.domain.ports.in.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {


    private final UserUseCase userUseCase;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userUseCase.findAll();
        return ResponseEntity.ok(users);
    }


    @PostMapping
    public void createUser() {

    }
}
