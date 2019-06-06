/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.controller;

import com.cibt.crm.repository.EnquirySourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author HP B&O
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {
    
    @Autowired
    private EnquirySourceRepository repository;
    
    @GetMapping
    public String index(Model model) {
        model.addAttribute("name", "CIBT");
        model.addAttribute("sources", repository.findAll());
        return "index";
    }
}
