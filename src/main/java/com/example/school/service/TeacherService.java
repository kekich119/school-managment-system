package com.example.school.service;

import com.example.school.model.Teacher;
import com.example.school.repository.TeachersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private final TeachersRepository teachersRepository;


    public TeacherService(TeachersRepository teachersRepository) {
        this.teachersRepository = teachersRepository;
    }

    public List<Teacher> findAllTeachers() {
        return teachersRepository.findAll();
    }

    public Teacher findByName(String name) {
        return teachersRepository.findByName(name);
    }

    public Teacher findById(Long id) {
        return teachersRepository.findById(id).get();
    }

}
