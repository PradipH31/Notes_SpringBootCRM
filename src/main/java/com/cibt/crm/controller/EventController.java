/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.controller;

import com.cibt.crm.entity.Event;
import com.cibt.crm.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author HP B&O
 */
@Controller
@RequestMapping(value = "/events")
public class EventController {
    
    @Autowired
    private EventRepository repository;
    
    @GetMapping
    public String index(){
        return "events/index";
    }
    
    @GetMapping(value = "/add")
    public String add(){
        return "events/add";
    }
    
    @PostMapping
    public String save(Event model){
        repository.save(model);
        return "redirect:/events";
    }
}
