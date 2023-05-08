package com.tekrar.demotekrari.controller.impl;

import com.tekrar.demotekrari.DemotekrariApplication;
import com.tekrar.demotekrari.controller.contrat.ProductController;
import com.tekrar.demotekrari.model.User;
import com.tekrar.demotekrari.model.entity.Product;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@RestController
public class ProductControllerImp implements ProductController {

   public ProductControllerImp() {
       DemotekrariApplication.products.add(pekle(1,"mandal",200,2.5));
       DemotekrariApplication.products.add(pekle(2,"musluk",24,50));
       DemotekrariApplication.products.add(pekle(3,"klozet",10,1200));
   }
   public Product pekle(int id,String product, int amount, double price){
       Product pu = new Product();
       pu.setId(id);
       pu.setProduct(product);
       pu.setAmount(amount);
       pu.setPrice(price);
       return pu;
   }

    @Override
    public String prodAdd(Product product) {

        Product p = new Product();

        p.setId(product.getId());
        p.setProduct(product.getProduct());
        p.setPrice(product.getPrice());
        p.setAmount(product.getAmount());
        DemotekrariApplication.products.add(p);
        return "Kaydedildi";
    }

    @Override
    public ArrayList<Product> prodAdd() {
        ArrayList<Product> ps = new ArrayList<>();
        return DemotekrariApplication.products;
    }

    @Override
    public String prodSale(Integer id,Integer amount) {
        for (int i = 0; i < DemotekrariApplication.users.size(); i++) {
            User user = DemotekrariApplication.users.get(i);

        }
        for (int i = 0; i < DemotekrariApplication.products.size(); i++) {
            Product satilanUrun = DemotekrariApplication.products.get(i);
            if(satilanUrun.getId() == id && satilanUrun.getAmount() > 0) {
                satilanUrun.setAmount(satilanUrun.getAmount()-1);

                return "ürün satıldı";
            }
        }
        return "Hata";
    }

}
