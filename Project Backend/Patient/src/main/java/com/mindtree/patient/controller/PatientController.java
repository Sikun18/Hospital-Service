package com.mindtree.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.patient.VO.ResponseTemplate;
import com.mindtree.patient.entity.Patient;
import com.mindtree.patient.service.PatientService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	PatientService stuService;
	
	@PostMapping
	public Patient add(@RequestBody Patient stu)
	
	{
		return stuService.add(stu);
	}
	
	@GetMapping
	public List<Patient> listStu(){
		return stuService.list();
	}
	
	@GetMapping("/{Id}")
	public ResponseTemplate stuWithClg(@PathVariable long Id)
	{
		return stuService.stuWithClg(Id);
	}
	
	@PutMapping("/{doctId}/{Id}")
	public String updateCollege(@PathVariable long Id,@PathVariable long doctId)
	{
		Patient stu = stuService.assignDoctor(doctId,Id);
		if(stu!=null)
		{
			return stu.toString();
		}
		return "Sorry. Doctor or Patient Not Found";
		
	}
	
	
	@GetMapping("/patient-with-desc-age/{dept_id}")
	public List<Patient> getPatientByDoctorWithDescAge(@PathVariable long id)
	{
		return stuService.getPatientByDoctorWithDescAge(id);
	}
	@GetMapping("/student-with-desc-age/{dept_id}")
	public List<Patient> getStudentByCollegeWithDescAge(@PathVariable long clg_id)
	{
		return stuService.getPatientByDoctorWithDescAge(clg_id);
	}
}









