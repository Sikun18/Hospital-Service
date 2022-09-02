package com.mindtree.patient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mindtree.patient.entity.Patient;

public interface PatientRepository  extends  JpaRepository<Patient, Long>{
	
	Patient findById(long id);

	@Query(value="SELECT * FROM patient WHERE clg_id=:clg_id ORDER BY name ASC", nativeQuery = true)
	List<Patient> getByClgId(@Param("clg_id") long clg_id);
	
	@Query(value="SELECT * FROM patient WHERE clg_id=:clg_id ORDER BY age DESC", nativeQuery = true)
	List<Patient> getPatientByDoctorWithDescAge(@Param("clg_id") long clg_id);


}
