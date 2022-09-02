package com.mindtree.doctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.doctor.VO.RequestTemplate;
import com.mindtree.doctor.entity.Doctor;
import com.mindtree.doctor.service.DoctorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	DoctorService doctService;
	
	
	@PostMapping
	public Doctor add(@RequestBody Doctor doct)
	{
		return doctService.add(doct);
	}
	
	@GetMapping
	public List<Doctor> list()
	{
		return doctService.list();
	}
	
	@GetMapping("/{id}")
	public Doctor searchById(@PathVariable long id)
	{
		return doctService.searchById(id);
	}
	
	@GetMapping("/all-doctors-patients")
	public List<RequestTemplate> listWithStu()
	{
		return doctService.listWithStu();
	}
	
	@GetMapping("/doctor-with-patients/{dept_id}")
	public RequestTemplate specificDoctStu(@PathVariable long doct_id)
	{
		return doctService.specificDoctPatient(doct_id);
	}
	
	
}


