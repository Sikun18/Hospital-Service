package com.mindtree.doctor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.doctor.VO.RequestTemplate;
import com.mindtree.doctor.entity.Doctor;

@Service
public interface DoctorService {
	
List<Doctor> list();
	
Doctor update(long id,String name);

Doctor searchById(long id);

	List<RequestTemplate> listWithStu();

	RequestTemplate specificDoctPatient(long doct_id);

	Doctor add(Doctor doct);
		


}
