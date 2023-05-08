package com.tekrar.demotekrari.controller.impl;

import com.tekrar.demotekrari.DemotekrariApplication;
import com.tekrar.demotekrari.controller.contrat.UserController;
import com.tekrar.demotekrari.model.User;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@RestController
public class UserControllerImp implements UserController {
    public int musteri;
    public UserControllerImp(){

        userEkle(1,"a@gmail.com","1234",5000.0,1);
        userEkle(2,"b@gmail.com","1234",5000.0,1);
        userEkle(3,"c@gmail.com","1234",5000.0,1);
        userEkle(4,"d@gmail.com","1234",5000.0,1);
    }
    private User userEkle(Integer id, String email, String password, Double balance, int roll){
        User us = new User();
        us.setId(id);
        us.setEmail(email);
        us.setPassword(password);
        us.setBalance(balance);
        us.setRoll(roll);
        DemotekrariApplication.users.add(us);
        return us;
    }
    @Override
    public ArrayList<User> user() {
        return DemotekrariApplication.users;
    }

    @Override
    public String user(User user) {
        User u = new User();
        int in = -1;
        for (int i = 0; i < DemotekrariApplication.users.size(); i++) {
            for (int j = 0; j < DemotekrariApplication.users.size(); j++) {
                if(in <= DemotekrariApplication.users.get(j).getId()){
                    in = DemotekrariApplication.users.get(j).getId();
                }
            }
        }
        in++;
        u.setId(in);
        u.setEmail(user.getEmail());
        for (User us: DemotekrariApplication.users) {
            if(us.getEmail().equals(user.getEmail())){
                return "bu e mail zaten kayıtlı";
            }
        }
        u.setPassword(user.getPassword());
        u.setBalance(5000.0);
        u.setRoll(user.getRoll());
        DemotekrariApplication.users.add(u);
        return "Kaydedildi";
    }

    public void setMusteri(int musteri) {
        this.musteri = musteri;
    }

    public int getMusteri() {
        return musteri;
    }
}
