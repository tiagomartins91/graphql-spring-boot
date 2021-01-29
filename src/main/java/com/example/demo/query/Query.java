package com.example.demo.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.domain.SampleRequest;
import com.example.demo.service.StudentService;
import com.example.demo.service.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    StudentService studentService;

    public String firstQuery() {
        return "First Query";
    }

    public String secondQuery() {
        return "Second Query";
    }

    /*
    public String fullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }
    */

    public String fullName(SampleRequest sampleRequest){
        return sampleRequest.getFirstName() + " " + sampleRequest.getLastName();
    }

    public StudentDTO getStudent(long id){
        // can be change to spring mapper
        return new StudentDTO(studentService.getById(id));
    }
}
