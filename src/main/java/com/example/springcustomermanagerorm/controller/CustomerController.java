package com.example.springcustomermanagerorm.controller;

import com.example.springcustomermanagerorm.model.Customer;
import com.example.springcustomermanagerorm.service.CustomerService;
import com.example.springcustomermanagerorm.service.GeneralDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public String showList(Model model) {
        List<Customer> customers = this.customerService.findAll();
        model.addAttribute("customers", customers);
        return "/list";
    }

    @GetMapping("create")
    public String showCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    @PostMapping("save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }
}
