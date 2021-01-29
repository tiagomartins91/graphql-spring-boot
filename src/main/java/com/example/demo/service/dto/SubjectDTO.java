package com.example.demo.service.dto;

import com.example.demo.domain.Subject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDTO {

	private Long id;
	
	private String subjectName;

	private Double marksObtained;
	
	public SubjectDTO(Subject subject) {
		this.id = subject.getId();
		this.subjectName = subject.getSubjectName();
		this.marksObtained = subject.getMarksObtained();
	}
}
