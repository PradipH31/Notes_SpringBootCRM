package com.cibt.crm.repository;

import com.cibt.crm.entity.EnquirySource;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HP B&O
 */
@Repository
public interface EnquirySourceRepository extends JpaRepository<EnquirySource, Long> {

    @Query(nativeQuery = true, value = "select * from mst_enquiry_sources where is_deleted=0")
    List<EnquirySource> getEnquirySources();
}
