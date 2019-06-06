/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.base;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author HP B&O
 */
public abstract class SiteController {
    protected String header;
    
    @ModelAttribute
    public void setHeader(Model model){
        model.addAttribute("header", header);
    }
}
