package com.tekrar.demotekrari.controller.contrat;

import com.tekrar.demotekrari.model.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public interface ProductController {
    @PostMapping("/urun")
    String prodAdd(@RequestBody Product product);
    @GetMapping("/urun")
    ArrayList<Product> prodAdd();
    @GetMapping("urunsat")
    String prodSale(@RequestParam Integer id,@RequestParam Integer amount);
}
