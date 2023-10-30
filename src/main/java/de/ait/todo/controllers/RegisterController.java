package de.ait.todo.controllers;

import de.ait.todo.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 10/30/2023
 * backend-demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RestController
public class RegisterController {

    @Autowired
    private SignUpService service;


    @PostMapping("/register")
    public void register() {
        System.out.println("А теперь есть :)");
    }
}
