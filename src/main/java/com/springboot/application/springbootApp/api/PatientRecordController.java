package com.springboot.application.springbootApp.api;

import com.springboot.application.springbootApp.exception.InvalidRequestException;
import com.springboot.application.springbootApp.exception.NoDataFoundException;
import com.springboot.application.springbootApp.model.PatientRecord;
import com.springboot.application.springbootApp.response.Response;
import com.springboot.application.springbootApp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.springboot.application.springbootApp.repository.PatientRecordRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/patient")
public class PatientRecordController {

    @Autowired
    PatientRecordRepository patientRecordRepository;
    @Autowired
    PatientService patientService;

    @GetMapping(value="/all/records")
    public ResponseEntity<Response> getAllRecords() {
        Response <PatientRecord>response=new Response<>();
        List<PatientRecord> result=patientService.findAllRecords();
        response.setResult(result);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "{patientId}")
    public PatientRecord getPatientById(@PathVariable(value="patientId") Long patientId) {
        return patientRecordRepository.findById(patientId).get();
    }
    @PostMapping
    public PatientRecord createRecord(@RequestBody @Valid PatientRecord patientRecord) {
        return patientRecordRepository.save(patientRecord);
    }
    @PutMapping
    public PatientRecord updatePatientRecord(@RequestBody PatientRecord patientRecord) throws NoDataFoundException {
        if (patientRecord == null || patientRecord.getPatientId() == null) {
            throw new InvalidRequestException("PatientRecord or ID must not be null!");
        }
        Optional<PatientRecord> optionalRecord = patientRecordRepository.findById(patientRecord.getPatientId());
        if (!optionalRecord.isPresent()) {
            throw new NoDataFoundException("Patient with ID " + patientRecord.getPatientId() + " does not exist.");
        }
        PatientRecord existingPatientRecord = optionalRecord.get();

        existingPatientRecord.setName(patientRecord.getName());
        existingPatientRecord.setAge(patientRecord.getAge());
        existingPatientRecord.setAddress(patientRecord.getAddress());

        return patientRecordRepository.save(existingPatientRecord);
    }
}
