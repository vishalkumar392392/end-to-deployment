package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.Student;

@RestController
public class StudentController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<Student> list = new ArrayList<>();

	@PostMapping("/save")
	public Student save(@RequestBody Student student) {
		list.add(new Student(1, student.getName(), student.getPhoneNumber()));
		logger.info("student saved: {}", student);
		return student;
	}

	@GetMapping("/getAll")
	public List<Student> getAllStudents() {
		return list;
	}
}
