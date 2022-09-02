package com.mindtree.patient.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mindtree.patient.VO.Doctor;
import com.mindtree.patient.VO.ResponseTemplate;
import com.mindtree.patient.entity.Patient;
import com.mindtree.patient.repository.PatientRepository;
import com.mindtree.patient.service.PatientService;


@Component
public class PatientImpl  implements PatientService{
	
	@Autowired
	private PatientRepository stuRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	

	@Override
	public Patient add(Patient stu) {
		// TODO Auto-generated method stub
		return stuRepo.save(stu);
	}

	@Override
	public List<Patient> list() {
		// TODO Auto-generated method stub
		return stuRepo.findAll();
	}

	@Override
	public Patient searchById(long id) {
		// TODO Auto-generated method stub
		return stuRepo.findById(id);
	}

	@Override
	public ResponseTemplate stuWithClg(long stuId) {
		// TODO Auto-generated method stub
		ResponseTemplate RT = new ResponseTemplate();
		Patient stu = stuRepo.findById(stuId);
		
		long Id =stu.getId();
		Doctor clg = restTemplate.getForObject("http://DOCTOR-SERVICE/doctor/"+Id, Doctor.class);
		RT.setDoctor(clg);
		RT.setPatient(stu);
		return RT;
	}
	
	@Override
	public Patient assignDoctor(long stuId, long Id) {
		// TODO Auto-generated method stub
		Patient stu = stuRepo.findById(stuId);
		Doctor clg = restTemplate.getForObject("http://DOCTOR-SERVICE/doctor/"+Id, Doctor.class);
		if(stu==null || clg==null)
		{
			return null;
		}
		stu.setId(Id);
		stuRepo.save(stu);
		return stu;
	
		
	}
		
	@Override
	public List<Patient> getByClgId(long clg_id) {
		// TODO Auto-generated method stub
		return stuRepo.getByClgId(clg_id);
	}

	@Override
	public List<Patient> getPatientByDoctorWithDescAge(long clg_id) {
		// TODO Auto-generated method stub
		return stuRepo.getPatientByDoctorWithDescAge(clg_id);   
	}
	
	


}




