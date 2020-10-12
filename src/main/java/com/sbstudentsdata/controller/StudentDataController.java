package com.sbstudentsdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sbstudentsdata.model.data.StudentDataModel;
import com.sbstudentsdata.service.StudentDataService;

@RestController
public class StudentDataController implements StudentControllerDocumentation{

	@Autowired
	private StudentDataService studentDataService;
	
	@GetMapping("/allstudentsData")
	public List<StudentDataModel> getAllStudentsData(){
		
		return studentDataService.getAllStudentsData();	
	}
	
	@GetMapping("/getStudentData")
	public ResponseEntity<String> getStudentDataById(@RequestParam("studentrollno") long rollno) {
		
		return studentDataService.getStudentDataById(rollno);
	}
	
	@PostMapping("/addStudentData")
	public ResponseEntity<String> addStudentData(@RequestBody StudentDataModel studentDataModel){
		
		return studentDataService.addStudentData(studentDataModel);
	}
	
	@PutMapping("/updateStudentData")
	public ResponseEntity<String> updateStudentData(@RequestBody StudentDataModel studentDataModel){
		
		return studentDataService.updateStudentData(studentDataModel);
	}
	
	@DeleteMapping("/deleteStudentDataById/{studentRollNo}")
	public ResponseEntity<String> deleteStudentDataByRollNo(@PathVariable("studentRollNo") long rollno){
		
		return studentDataService.deleteStudentDataByRollNo(rollno);
	}
	
	@DeleteMapping("/deleteAllStudentsData")
	public ResponseEntity<String> deleteAllStudentsData(){
		
		return studentDataService.deleteAllStudentsData();
	}
	
	
	
}
