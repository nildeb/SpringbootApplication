package com.springboot.application.springbootApp.service;

import com.springboot.application.springbootApp.model.PatientRecord;

import java.util.List;

public interface PatientService {

    List<PatientRecord> findAllRecords();
}
