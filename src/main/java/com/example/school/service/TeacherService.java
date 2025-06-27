package com.example.school.service;

import com.example.school.model.Teacher;
import com.example.school.repository.TeachersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherService {
    private final TeachersRepository teachersRepository;
    private Teacher teacher;


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

    @Transactional
    public Teacher addTeacher(Teacher teacher) {
        return teachersRepository.save(teacher);
    }



}
