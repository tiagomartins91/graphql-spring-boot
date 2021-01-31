package com.example.demo.service.dto;

import java.util.List;

import com.example.demo.domain.Student;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentDTO {

	private long id;

	private String firstName;

	private String lastName;

	private String email;
	
	private String street;

	private String city;
	
	private List<SubjectDTO> learningSubjects;

	// this is for internal use, do not put in schema
	private Student student;

	private String fullName;
	
	public StudentDTO(Student student) {
		this.student  = student;
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
		
		this.street = student.getAddress().getStreet();
		this.city = student.getAddress().getCity();

		/* Moved to GraphQL Resolver (improve application performance)
		if (student.getLearningSubjects() != null) {
			learningSubjects = new ArrayList<>();
			for (Subject subject: student.getLearningSubjects()) {
				learningSubjects.add(new SubjectDTO(subject));
			}
		}
		 */
	}

}
