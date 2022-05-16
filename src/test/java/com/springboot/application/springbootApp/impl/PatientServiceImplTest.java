package com.springboot.application.springbootApp.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.application.springbootApp.api.PatientRecordController;
import com.springboot.application.springbootApp.exception.NoDataFoundException;
import com.springboot.application.springbootApp.model.PatientRecord;
import com.springboot.application.springbootApp.repository.PatientRecordRepository;
import com.springboot.application.springbootApp.service.PatientService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@WebMvcTest(PatientRecordController.class)
public class PatientServiceImplTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @InjectMocks
    PatientServiceImpl patientServiceImpl;

    @MockBean
    PatientService patientService;

    @Mock
    PatientRecordRepository patientRecordRepository;

    @MockBean
    PatientRecordRepository patientRecordRepository1;

    PatientRecord RECORD_1 = new PatientRecord(1l, "Rayven Yor", 23, "Cebu Philippines");
    PatientRecord RECORD_2 = new PatientRecord(2l, "David Landup", 27, "New York USA");
    PatientRecord RECORD_3 = new PatientRecord(3l, "Jane Doe", 31, "New York USA");

    @Test
    public void findAllRecords_success() {
        List<PatientRecord> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
        Mockito.when(patientRecordRepository1.findAll()).thenReturn(records);
        List<PatientRecord> result=patientServiceImpl.findAllRecords();
        Assertions.assertEquals(Collections.EMPTY_LIST,result);

    }




}