package com.mindtree.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.doctor.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	
	Doctor findById(long id);
	
	
}


