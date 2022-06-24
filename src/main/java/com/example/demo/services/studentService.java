package com.example.demo.services;


import java.util.List;

import com.example.demo.entity.*;

import lombok.extern.java.Log;

public interface studentService {
	List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudentById(Long id);
    Student updateStudent(Student student);
    void deleteStudentById(Long id);
	

}
