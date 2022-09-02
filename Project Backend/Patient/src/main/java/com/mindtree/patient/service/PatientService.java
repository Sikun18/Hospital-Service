package com.mindtree.patient.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.patient.VO.ResponseTemplate;
import com.mindtree.patient.entity.Patient;

@Service
public interface PatientService {
	
Patient add(Patient stu);
	
	List<Patient> list();
	
	Patient searchById(long id);

	ResponseTemplate stuWithClg(long stuId);

	Patient assignDoctor(long stuId, long doctId);

	List<Patient> getByClgId(long clg_id);

	List<Patient> getPatientByDoctorWithDescAge(long clg_id);


}
