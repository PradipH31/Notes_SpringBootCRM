/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.controller;

import com.cibt.crm.base.SiteController;
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
@RequestMapping(value = "/enquiry/sources")
public class EnquirySourceController extends SiteController {

    public EnquirySourceController() {
        this.header = "Enquiry Source";
    }

    @Autowired
    private EnquirySourceRepository repository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("records", repository.findAll());
        return "enquiry/source/index";
    }
    
    @GetMapping(value = "/add")
    public String add() {
        return "enquiry/source/add";
    }
}
