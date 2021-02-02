package com.example.demo.service;

import com.example.demo.domain.Address;
import com.example.demo.domain.Student;
import com.example.demo.domain.Subject;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.SubjectRepository;
import com.example.demo.service.dto.CreateStudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    SubjectRepository subjectRepository;

    public Student getById(long id) {
        return studentRepository.findById(id).get();
    }

    public Student createStudent(CreateStudentDTO createStudentDTO) {

        Student student = new Student(createStudentDTO);

        Address address = new Address();
        address.setStreet(createStudentDTO.getStreet());
        address.setCity(createStudentDTO.getCity());

        address = addressRepository.save(address);

        student.setAddress(address);
        Student finalNewStudent = studentRepository.save(student);

        List<Subject> subjectList = new ArrayList<>();

        createStudentDTO.getSubjectsLearning().forEach(each -> {
            Subject subject = new Subject();

            subject.setSubjectName(each.getSubjectName());
            subject.setMarksObtained(each.getMarksObtained());
            subject.setStudent(finalNewStudent);

            subjectList.add(subject);
        });

        if(!subjectList.isEmpty()) {
            subjectRepository.saveAll(subjectList);
        }

        student.setLearningSubjects(subjectList);

        return student;
    }
}
