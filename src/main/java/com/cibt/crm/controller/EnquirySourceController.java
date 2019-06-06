/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.controller;

import com.cibt.crm.base.SiteController;
import com.cibt.crm.entity.EnquirySource;
import com.cibt.crm.repository.EnquirySourceRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        model.addAttribute("records", repository.getEnquirySources());
        return "enquiry/source/index";
    }

    @GetMapping(value = "/add")
    public String add() {
        return "enquiry/source/add";
    }

    @PostMapping(value = "/add")
    public String save(EnquirySource model) {
        repository.save(model);
        return "redirect:/enquiry/sources?success";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("record", repository.getOne(id));
        return "enquiry/source/edit";
    }
    
    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        EnquirySource source=repository.getOne(id);
        source.setDeleted(true);
        source.setDeletedDate(new Date());
        repository.save(source);
        return "redirect:/enquiry/sources?success";
    }

}
