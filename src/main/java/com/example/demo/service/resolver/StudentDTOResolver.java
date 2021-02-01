package com.example.demo.service.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demo.domain.Subject;
import com.example.demo.domain.enums.SubjectNameFilter;
import com.example.demo.service.dto.StudentDTO;
import com.example.demo.service.dto.SubjectDTO;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentDTOResolver implements GraphQLResolver<StudentDTO> {

    public List<SubjectDTO> getLearningSubjects(StudentDTO studentDTO, SubjectNameFilter subjectNameFilter) {

        List<SubjectDTO> learningSubjects = new ArrayList<>();

        if (studentDTO.getStudent().getLearningSubjects() != null) {
            learningSubjects = new ArrayList<>();
            for (Subject subject: studentDTO.getStudent().getLearningSubjects()) {
                // filter data
                if (subjectNameFilter.name().equalsIgnoreCase(SubjectNameFilter.All.name())) {
                    learningSubjects.add(new SubjectDTO(subject));
                    continue;
                }

                if (subjectNameFilter.name().equalsIgnoreCase(subject.getSubjectName())) {
                    learningSubjects.add(new SubjectDTO(subject));
                }
            }
        }

        return learningSubjects;
    }

    public  String getFullName(StudentDTO studentDTO){
        return  studentDTO.getFirstName() + " " + studentDTO.getLastName();
    }
}
