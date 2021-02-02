package com.example.demo.service.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.service.StudentService;
import com.example.demo.service.dto.CreateStudentDTO;
import com.example.demo.service.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    StudentService studentService;

    public StudentDTO createStudent(CreateStudentDTO createStudentDTO) {
       return new StudentDTO(studentService.createStudent(createStudentDTO));
    }
}
