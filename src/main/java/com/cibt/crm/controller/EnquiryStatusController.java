/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.controller;

import com.cibt.crm.base.AdminBaseController;
import com.cibt.crm.entity.EnquiryStatus;
import com.cibt.crm.repository.EnquiryStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
