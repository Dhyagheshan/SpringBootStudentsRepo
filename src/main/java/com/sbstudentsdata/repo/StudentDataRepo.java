package com.sbstudentsdata.repo;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbstudentsdata.model.data.StudentDataModel;

@Repository
public interface StudentDataRepo extends JpaRepository<StudentDataModel, Long> {
	
	Optional<StudentDataModel> findByRollno(long rollno);
	
	@Transactional
	public void deleteStudentDataModelByRollno(long rollno);

}
