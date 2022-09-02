package com.mindtree.doctor.VO;

import java.util.ArrayList;
import java.util.List;

import com.mindtree.doctor.entity.Doctor;


public class RequestTemplate {
	
	private Doctor doctor;
	private List<Patient> patientList = new ArrayList<Patient>();
	
	
	
	
	public RequestTemplate ( Doctor doctor, List<Patient> patientList) {
		super();
		this.doctor = doctor;
		this.patientList = patientList;
	}

	

	public Doctor getDoctor() {
		return doctor;
	}
	
	public void setDoctor( Doctor doctor) {
		this.doctor = doctor;
	}


	public List<Patient> getPatientList() {
		return patientList;
	}

	
	public void setPatientList(List<Patient> patientList) {
		this.patientList= patientList;
	}
	
	public RequestTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}
	





	




}
