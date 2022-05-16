package com.springboot.application.springbootApp.impl;

import com.springboot.application.springbootApp.exception.NoDataFoundException;
import com.springboot.application.springbootApp.model.PatientRecord;
import com.springboot.application.springbootApp.repository.PatientRecordRepository;
import com.springboot.application.springbootApp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRecordRepository patientRecordRepository;

    @Override
   public List<PatientRecord> findAllRecords(){
       return patientRecordRepository.findAll();

    }

    @Override
   public  PatientRecord findPatientById( long patientId){
        Optional<PatientRecord> record  = patientRecordRepository.findById(patientId);
        if (!record.isPresent()) {
            throw new NoDataFoundException("Patient with ID " + patientId + " does not exist.");
        }
        return record.get();
    }

}
