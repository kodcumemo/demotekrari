package com.tekrar.demotekrari.controller.contrat;

import com.tekrar.demotekrari.request.Sales;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public interface SalesController {

    @PostMapping("/sales")
    String sales(@RequestBody Sales sales);
    @GetMapping("/sales")
    ArrayList<Sales> salesShow();
}
