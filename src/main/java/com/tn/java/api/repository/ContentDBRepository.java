package com.tn.java.api.repository;

import com.tn.java.api.model.ContentDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentDBRepository extends JpaRepository<ContentDB, String> {

}
