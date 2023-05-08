package com.tekrar.demotekrari.controller.contrat;

import com.tekrar.demotekrari.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public interface UserController {
    @GetMapping("/user")
    ArrayList<User> user();

    @PostMapping("/user")
    String user(@RequestBody User user);
}
