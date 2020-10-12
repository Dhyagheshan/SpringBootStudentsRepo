package com.sbstudentsdata.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.sbstudentsdata.model.data.StudentDataModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.*;

public interface StudentControllerDocumentation {
	
	@Operation(method="GET")
	@ApiResponses(value= {
			@ApiResponse(responseCode="201",description="Request Processed"),
			@ApiResponse(responseCode="200",description="Request OK"),
			@ApiResponse(responseCode="400",description="Bad Request"),
			@ApiResponse(responseCode="404",description="Not Found"),
			@ApiResponse(responseCode="409",description="Request Conflicts"),
			@ApiResponse(responseCode="500",description="Internal Server Error"),		
	})
	List<StudentDataModel> getAllStudentsData();
	
	@Operation(method="GET")
	@ApiResponses(value= {
			@ApiResponse(responseCode="201",description="Request Processed"),
			@ApiResponse(responseCode="200",description="Request OK"),
			@ApiResponse(responseCode="400",description="Bad Request"),
			@ApiResponse(responseCode="404",description="Not Found"),
			@ApiResponse(responseCode="409",description="Request Conflicts"),
			@ApiResponse(responseCode="500",description="Internal Server Error"),		
	})
	ResponseEntity<String> getStudentDataById(@Parameter @RequestParam @Valid long rollno);
	
	@Operation(method="POST")
	@ApiResponses(value= {
			@ApiResponse(responseCode="201",description="Request Processed"),
			@ApiResponse(responseCode="200",description="Request OK"),
			@ApiResponse(responseCode="400",description="Bad Request"),
			@ApiResponse(responseCode="404",description="Not Found"),
			@ApiResponse(responseCode="409",description="Request Conflicts"),
			@ApiResponse(responseCode="500",description="Internal Server Error"),		
	})
	ResponseEntity<String> addStudentData(@Parameter @RequestBody @Valid StudentDataModel request);
	
	@Operation(method="PUT")
	@ApiResponses(value= {
			@ApiResponse(responseCode="201",description="Request Processed"),
			@ApiResponse(responseCode="200",description="Request OK"),
			@ApiResponse(responseCode="400",description="Bad Request"),
			@ApiResponse(responseCode="404",description="Not Found"),
			@ApiResponse(responseCode="409",description="Request Conflicts"),
			@ApiResponse(responseCode="500",description="Internal Server Error"),		
	})
	ResponseEntity<String> updateStudentData(@Parameter @RequestBody @Valid StudentDataModel request);
	
	@Operation(method="DELETE")
	@ApiResponses(value= {
			@ApiResponse(responseCode="201",description="Request Processed"),
			@ApiResponse(responseCode="200",description="Request OK"),
			@ApiResponse(responseCode="400",description="Bad Request"),
			@ApiResponse(responseCode="404",description="Not Found"),
			@ApiResponse(responseCode="409",description="Request Conflicts"),
			@ApiResponse(responseCode="500",description="Internal Server Error"),		
	})
	ResponseEntity<String> deleteStudentDataByRollNo(@Parameter @RequestParam @Valid long rollno);
	
	@Operation(method="DELETE")
	@ApiResponses(value= {
			@ApiResponse(responseCode="201",description="Request Processed"),
			@ApiResponse(responseCode="200",description="Request OK"),
			@ApiResponse(responseCode="400",description="Bad Request"),
			@ApiResponse(responseCode="404",description="Not Found"),
			@ApiResponse(responseCode="409",description="Request Conflicts"),
			@ApiResponse(responseCode="500",description="Internal Server Error"),		
	})
	ResponseEntity<String> deleteAllStudentsData();
	
	
	

}
