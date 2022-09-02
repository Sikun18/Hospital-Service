package com.mindtree.patient.VO;

import com.mindtree.patient.entity.Patient;

public class ResponseTemplate {

	private Patient patient;
	private Doctor doctor;
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public ResponseTemplate(Patient patient, Doctor doctor) {
		super();
		this.patient = patient;
		this.doctor = doctor;
	}
	public ResponseTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

}
