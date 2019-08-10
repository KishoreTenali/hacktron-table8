package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@SpringBootTest
class DemoApplicationTests {

   @Autowired
   private CustomerRepository customerRepository;

   @Test
   public void whenCreateCutomer() {
    customerRepository.save(new Customer("sunil", "sunil@gmail.com"));
   }
}
