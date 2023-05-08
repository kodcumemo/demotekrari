package com.tekrar.demotekrari.controller.impl;

import com.tekrar.demotekrari.DemotekrariApplication;
import com.tekrar.demotekrari.controller.contrat.SalesController;
import com.tekrar.demotekrari.model.User;
import com.tekrar.demotekrari.model.entity.Product;
import com.tekrar.demotekrari.request.Sales;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SalesControllerImp implements SalesController {
    public SalesControllerImp() {
       // salesEkle("a@gmail.com","1234","musluk");
       // salesEkle("b@gmail.com","1234","klozet");
       // salesEkle("c@gmail.com","1234","musluk");
       // salesEkle("c@gmail.com","1234","lavabo");
    }

    private void salesEkle(String email, String password, String product) {
        Sales s = new Sales();
        s.setEmail(email);
        s.setPassword(password);
        s.setProduct(product);
        DemotekrariApplication.saless.add(s);
    }

    @Override
    public String sales(Sales istenen) {
        String urun = null;
        for (int i = 0; i < DemotekrariApplication.users.size(); i++) {
            User user = DemotekrariApplication.users.get(i);
            if(user.getEmail().equals(istenen.getEmail()) && user.getPassword().equals(istenen.getPassword())) {
                for (int j = 0; j < DemotekrariApplication.products.size(); j++) {
                    Product product = DemotekrariApplication.products.get(j);
                    urun = product.getProduct();
                    if(product.getProduct().equals(istenen.getProduct())) {
                        if(product.getAmount() <= 0){
                            return istenen.getProduct() + " tükendi";
                        } else if (product.getPrice() > user.getBalance()) {
                            return product.getPrice() + " " + user.getBalance() + "Paranız yetersiz";
                        } else {
                            product.setAmount(product.getAmount()-1);
                            user.setBalance(user.getBalance()- product.getPrice());
                            DemotekrariApplication.saless.add(istenen);
                            return  "" + istenen.getProduct()  + " satın aldınız";
                        }
                    }
                }
                return   user.getEmail() + " " + istenen.getEmail() + " " + urun + " " + istenen.getProduct() + " bulunamadı";
            }
        }
        return "Kullanıcı adı veya şifre hatalı";
    }

    @Override
    public ArrayList<Sales> salesShow() {
        return DemotekrariApplication.saless;
    }
}
