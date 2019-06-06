/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.controller;

import com.cibt.crm.base.AdminBaseController;
import com.cibt.crm.base.SiteController;
import com.cibt.crm.entity.EnquiryStatus;
import com.cibt.crm.repository.EnquiryStatusRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HP B&O
 */
@Controller
@RequestMapping(value = "/enquiry/status")
public class EnquiryStatusController extends AdminBaseController<EnquiryStatus> {

    public EnquiryStatusController() {
        this.header = "Enquiry Status";
        this.viewPath = "enquiry/status";
        this.redirectURI = "/enquiry/status";;
    }

    @Autowired
    private EnquiryStatusRepository repository;

    @PostMapping()
    public String save(EnquiryStatus model, @RequestParam(value = "addmore", required = false) String addMore) {
        repository.save(model);
        if (addMore == null) {
            return "redirect:/enquiry/status?success";
        } else {
            return "redirect:/enquiry/status/add?success";
        }
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("record", repository.getOne(id));
        return "enquiry/status/edit";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        EnquiryStatus status = repository.getOne(id);
        status.setDeleted(true);
        status.setDeletedDate(new Date());
        repository.save(status);
        return "redirect:/enquiry/status?success";
    }

}
