package com.example.school.service;

import com.example.school.model.Teacher;
import com.example.school.repository.TeachersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public boolean existsByName(String name) {
        return teachersRepository.existsByName(name);
    }

    @Transactional
    public void addTeacher(Teacher teacher) {
        teachersRepository.save(teacher);
    }

    public void deleteTeacherByName(String name) {
        teachersRepository.deleteTeacherByName(name);
    }

    public List<Teacher> filterTeacherBySubject(String subject) {
        System.out.println("filterTeacherBySubject: " + subject);
        return teachersRepository.findTeachersBySubject(subject);
    }



    public boolean validateByAge(int age) {
        if (age < 18 || age > 100) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateByNameLength(String name, String lastName) {
        if (name.length() < 3 || name.length() > 10 || lastName.length() < 3 || lastName.length() > 10) {
            return true;
        } else {
            return false;
        }


    }
}



