/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.repository;

import com.cibt.crm.entity.EnquiryStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author HP B&O
 */
public interface EnquiryStatusRepository extends JpaRepository<EnquiryStatus, Long> {

    @Query(nativeQuery = true, value = "select * from mst_enquiry_status where is_deleted=0")
    List<EnquiryStatus> getAll();
}
