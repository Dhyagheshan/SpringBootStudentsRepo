package com.sbstudentsdata.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sbstudentsdata.repo.StudentDataRepo;

import com.sbstudentsdata.model.data.StudentDataModel;

@Service
public class StudentDataService {

	@Autowired
	private StudentDataRepo studentDataRepo;
	
	public List<StudentDataModel> getAllStudentsData(){
		
		List<StudentDataModel> studentsDataList =new ArrayList<>();
		studentsDataList=studentDataRepo.findAll();
		return studentsDataList;	
	}
	
	public ResponseEntity<String> getStudentDataById(long rollno) {
		
		ResponseEntity<String> response; 
		Optional<StudentDataModel> studentDataModel=studentDataRepo.findByRollno(rollno);
		if(studentDataModel.isPresent()) {
			response = new ResponseEntity<String>("The Student Data for the RollNo: "+rollno+" is the following: \n"+studentDataModel.toString(),HttpStatus.FOUND);
		}
		else {
			response = new ResponseEntity<String>("The Student Data for the RollNo: "+rollno+" does not exist. Recheck the Student RollNo Specified.",HttpStatus.NOT_FOUND);
		}
		return response;
		}
	
	public ResponseEntity<String> addStudentData(StudentDataModel studentData){
		
		Optional<StudentDataModel> studentDataModel=studentDataRepo.findByRollno(studentData.getRollno());
		ResponseEntity<String> response;
		
		if(!studentDataModel.isPresent()) {
			studentDataRepo.save(studentData);
			response = new ResponseEntity<String>("The following Student Data is added to the Database.\n"+studentData.toString(),HttpStatus.OK);
		}
		else {
			response = new ResponseEntity<String>("The Specified Student RollNo "+studentData.getRollno()+" already exists for another Student Data. Delete the already existing Student Data or use Update Student Data",HttpStatus.CONFLICT );
		}		
		return response;
		
	}
	
	public ResponseEntity<String> updateStudentData(StudentDataModel studentDataModel){
		
		ResponseEntity<String> response;
		if(studentDataRepo.findByRollno(studentDataModel.getRollno()).isPresent()) {
			studentDataModel.setStudentName(studentDataModel.getStudentName());
			studentDataModel.setDateOfBirth(studentDataModel.getDateOfBirth());
			studentDataModel.setEmailAddress(studentDataModel.getEmailAddress());
			studentDataModel.setContactNumber(studentDataModel.getContactNumber());
			studentDataRepo.save(studentDataModel);
			response = new ResponseEntity<String>("The Student Data for RollNo: "+studentDataModel.getRollno()+" is updated and is as follows:\n"+studentDataModel.toString(),HttpStatus.OK);
		}
		else {
			response = new ResponseEntity<String>("The Student Data for the RollNo: "+studentDataModel.getRollno()+" does not exist. Recheck the Student RollNo Specified.",HttpStatus.NOT_FOUND);
		}		
		return response;
	}
	
	public ResponseEntity<String> deleteStudentDataByRollNo(long rollno){
		
		Optional<StudentDataModel> studentDataModel=studentDataRepo.findByRollno(rollno);
		ResponseEntity<String> response;
		if(studentDataModel.isPresent()) {
			studentDataRepo.deleteStudentDataModelByRollno(rollno);
			response = new ResponseEntity<String>("The following Student Data is deleted from the Database.\n"+studentDataModel.toString(),HttpStatus.OK);
		}
		else {
			response = new ResponseEntity<String>("The Student Data for the RollNo: "+rollno+" does not exist. Recheck the Student RollNo Specified.",HttpStatus.NOT_FOUND);
		}		
		return response;
	}
	
	public ResponseEntity<String> deleteAllStudentsData(){
		
		studentDataRepo.deleteAll();
		return new ResponseEntity<String>("All the Students Data in the Database is deleted.",HttpStatus.OK);
	}
}
