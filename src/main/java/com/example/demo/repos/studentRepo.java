package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entites.Student;

public interface studentRepo extends JpaRepository<Student,Integer> {

}
