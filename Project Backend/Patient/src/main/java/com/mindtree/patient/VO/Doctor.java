package com.mindtree.patient.VO;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mindtree.patient.entity.Patient;

@Entity
@Table
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	   private Integer age;
	    private String gender;
	    private String field;
	    private Integer patient_count = 0;

	    @OneToMany
	    private List<Patient> patients;

	    public List<Patient> getPatients() {
	        return patients;
	    }

	    public void addPatients(Patient patient) {
	        patients.add(patient);
	    }

	    public Doctor() {
	    }

	    public Doctor(String name, Integer age, String gender, String field) {
	        this.name = name;
	        this.age = age;
	        this.gender = gender;
	        this.field = field;
	    }

	    @Override
	    public String toString() {
	        return "Doctor [age=" + age + ", field=" + field + ", gender=" + gender + ", id=" + id + ", name=" + name + "]";
	    }

	    public Integer getPatient_count() {
	        return patient_count;
	    }

	    public void setPatient_count() {
	        this.patient_count += 1;
	    }

	    public Long getId() {
	        return id;
	    }

	    protected void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Integer getAge() {
	        return age;
	    }

	    public void setAge(Integer age) {
	        this.age = age;
	    }

	    public String getGender() {
	        return gender;
	    }

	    public void setGender(String gender) {
	        this.gender = gender;
	    }

	    public String getField() {
	        return field;
	    }

	    public void setField(String field) {
	        this.field = field;
	    }

	}