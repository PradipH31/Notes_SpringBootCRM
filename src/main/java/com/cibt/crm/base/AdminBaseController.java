/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HP B&O
 */
public abstract class AdminBaseController<T> extends SiteController {

    @Autowired
    protected JpaRepository<T, Long> repository;
    protected String viewPath, redirectURI;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("records", repository.findAll());
        return viewPath + "/index";
    }

    @GetMapping(value = "/add")
    public String add() {
        return viewPath + "/add";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("record", repository.getOne(id));
        return viewPath + "/edit";
    }

    @PostMapping
    public String save(T model, @RequestParam(value = "addmore", required = false) String addMore) {
        repository.save(model);
        if (addMore == null) {
            return "redirect:" + redirectURI + "?success";
        }
        return "redirect:" + redirectURI + "/add?success";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        T model = repository.getOne(id);
        repository.delete(model);
        return "redirect:" + redirectURI + "?success";
    }
}
