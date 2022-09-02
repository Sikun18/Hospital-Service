package com.mindtree.doctor.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mindtree.doctor.VO.Patient;
import com.mindtree.doctor.VO.RequestTemplate;
import com.mindtree.doctor.entity.Doctor;
import com.mindtree.doctor.repository.DoctorRepository;
import com.mindtree.doctor.service.DoctorService;


@Component
public class DoctorImpl implements DoctorService{

	
	@Autowired
	DoctorRepository doctRepo;
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public Doctor add(Doctor doct) {
		// TODO Auto-generated method stub
		return doctRepo.save(doct);
	}

	@Override
	public List<Doctor> list() {
		// TODO Auto-generated method stub
		return doctRepo.findAll();
	}

	@Override
	public Doctor update(long id, String name) {
		// TODO Auto-generated method stub
		Doctor dept = doctRepo.findById(id);
		dept.setName(name);
		return doctRepo.save(dept);
		
	}

	@Override
	public Doctor searchById(long id) {
		// TODO Auto-generated method stub
		if(doctRepo.findById(id)==null)
		{
			return null;
		}
		return doctRepo.findById(id);
	}

	@Override
	public List<RequestTemplate> listWithStu() {
		// TODO Auto-generated method stub
		List<RequestTemplate> fullList = new ArrayList<RequestTemplate>();
		List<Doctor> allDoct = this.list();
		Iterator<Doctor> ir = allDoct.iterator();
		while(ir.hasNext())
		{
			Doctor clgs = ir.next();
			ResponseEntity<Patient[]> response =
					  restTemplate.getForEntity(
							  "http://PATIENT-SERVICE/patient/patient-with-ascname/"+clgs.getId(),
							  Patient[].class);
			Patient[] patients = response.getBody();
			List<Patient> stus = Arrays.asList(patients);
 			RequestTemplate RTm = new RequestTemplate();
			RTm.setDoctor(clgs);
			RTm.setPatientList(stus);
			fullList.add(RTm);
		}
		return fullList;
	}

	@Override
	public RequestTemplate specificDoctPatient(long doct_id) {
		
		
        Doctor doctor  = this.searchById(doct_id);
		
		ResponseEntity<Patient[]> response =
				  restTemplate.getForEntity(
						  "http://PATIENT-SERVICE/patient/patient-with-desc-age/"+doctor.getId(),
						  Patient[].class);
		Patient[] patient = response.getBody();
		List<Patient> patients = Arrays.asList(patient);
		RequestTemplate requestTemplate = new RequestTemplate();
		
		requestTemplate.setDoctor(doctor);
		requestTemplate.setPatientList(patients);
		
		return requestTemplate;
	}
}
