package com.example.school.repository;

import com.example.school.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeachersRepository extends JpaRepository<Teacher, Long> {


    void deleteTeacherByName(String name);

    List<Teacher> findTeachersBySubject(String subject);
}
