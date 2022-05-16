package com.springboot.application.springbootApp.repository;

import com.springboot.application.springbootApp.model.PatientRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientRecordRepository extends JpaRepository<PatientRecord,Long> {

}


