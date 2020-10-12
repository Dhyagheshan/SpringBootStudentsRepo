package com.sbstudentsdata.model.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.sbstudentsdata.model.validation.ContactNum;
import com.sbstudentsdata.model.validation.DateFormat;

import io.swagger.v3.oas.annotations.media.Schema;


@Entity
@Table(name="studentdata")
public class StudentDataModel {

	@Id
	@Column(name="rollno")
	@NotNull
	@Schema(required=true,example="101",description="The RollNo should be unique to each Student. This field is also used as a primary key in the Database.")
	private long rollno;
	
	@Column(name="name")
	@NotBlank
	@Schema(required=true,example="Jack",description="Name of the Student")
	private String studentName;
	
	@Column(name="dob")
	@DateFormat
	@NotBlank
	@Schema(required=true,example="10-04-2004",description="Date Of Birth of the Student. The Student must be born after 1971.")
	private String dateOfBirth;
	
	@Column(name="emailAddress")
	@Email
	@NotBlank
	@Schema(required=true,example="john@student.com",description="Email Address of the Student. This field should be in a valid format")
	private String emailAddress;
	
	@Column(name="contactNumber")
	@ContactNum
	@Schema(required=false,example="1234567891",description="Contact Number of the Student. This is an Optional Field")
	private String ContactNumber;

	public long getRollno() {
		return rollno;
	}

	public void setRollno(long rollno) {
		this.rollno = rollno;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getContactNumber() {
		return ContactNumber;
	}

	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "StudentDataModel [ rollNumber=" + rollno + ", studentName="
				+ studentName + ", dateOfBirth=" + dateOfBirth + ", emailAddress=" + emailAddress + ", ContactNumber="
				+ ContactNumber + "]";
	}
	
	
	
	
	
}
