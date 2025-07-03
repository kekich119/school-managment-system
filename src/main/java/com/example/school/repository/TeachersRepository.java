package com.example.school.repository;

import com.example.school.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TeachersRepository extends JpaRepository<Teacher, Long> {


    void deleteTeacherByName(String name);

    @Transactional(readOnly = true)
    List<Teacher> findTeachersBySubject(String subject);

    boolean existsByName(String name);
}
