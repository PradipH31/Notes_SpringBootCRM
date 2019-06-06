/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.controller;

import com.cibt.crm.entity.EnquirySource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
    private JdbcTemplate template;
    
    @GetMapping
    public String index(Model model) {
        List<EnquirySource> sources = template.query("select * from mst_enquiry_sources", new RowMapper<EnquirySource>() {
            @Override
            public EnquirySource mapRow(ResultSet rs, int i) throws SQLException {
                return new EnquirySource(rs.getInt("id"), rs.getString("source_name"), rs.getString("source_color"));
            }
        });
        model.addAttribute("name", "CIBT");
        model.addAttribute("sources", sources);
        return "index";
    }
}
