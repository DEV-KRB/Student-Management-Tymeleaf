package com.eculant.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eculant.thymeleaf.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
