/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.controller;

import com.cibt.crm.base.AdminBaseController;
import com.cibt.crm.entity.EnquirySource;
import com.cibt.crm.repository.EnquirySourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author HP B&O
 */
@Controller
@RequestMapping(value = "/enquiry/sources")
public class EnquirySourceController extends AdminBaseController<EnquirySource> {

    public EnquirySourceController() {
        this.header = "Enquiry Source";
        this.viewPath = "enquiry/source";
        this.redirectURI = "/enquiry/sources";
    }

    @Autowired
    private EnquirySourceRepository repository;

}
