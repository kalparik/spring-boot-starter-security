package com.example.secureapplication.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ApplicationRepository {

    @Autowired
    public ApplicationRepository() {
    }

    public String hi(){
        return "Hi guest. Welcome to the website!";
    }
    public String read(){
        return "Access to reading messages";
    }
    public String send(){
        return "Access to send message";
    }
    public String delete(){
        return "Access to delete message";
    }
}
