package com.example.apendixb;

import dataaccess.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import dataaccess.chinookDAO;

import static dataaccess.chinookDAO.*;

@SpringBootApplication
public class AppendixBApplication implements ApplicationRunner {



    public static void main(String[] args) {
        SpringApplication.run(AppendixBApplication.class, args);
        chinookDAO chinookDAO = new chinookDAO();

        chinookDAO.countryWithMostCustomers();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
