package com.example.school.service;

import com.example.school.model.Teacher;
import com.example.school.repository.TeachersRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Arrays;
import java.util.List;

@Service

public class TeacherService {
    private final TeachersRepository teachersRepository;
    JedisPool jedisPool = new JedisPool("localhost", 6379);
    private final ObjectMapper mapper;


    public TeacherService(TeachersRepository teachersRepository, ObjectMapper objectMapper) {
        this.teachersRepository = teachersRepository;
        this.mapper = objectMapper;
    }

    public List<Teacher> findAllTeachers() {
        return teachersRepository.findAll();
    }

    public List<Teacher> getChachAllTeachers() {
        try(Jedis jedis = jedisPool.getResource()) {
            if (jedis.exists("teachers")) {
                String json = jedis.get("teachers");
                return Arrays.asList(mapper.readValue(json, Teacher[].class));
            }else {
                List<Teacher> teachers = teachersRepository.findAll();
                jedis.set("teachers",  mapper.writeValueAsString(teachers));
                jedis.expire("teachers", 60);
                return teachers;
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean existsByName(String name) {
        return teachersRepository.existsByName(name);
    }

    @Transactional
    public void addTeacher(Teacher teacher) {
        teachersRepository.save(teacher);
        try(Jedis jedis = jedisPool.getResource()) {
            jedis.del("teachers");
        }
    }

    public void deleteTeacherByName(String name) {
        teachersRepository.deleteTeacherByName(name);
        try(Jedis jedis = jedisPool.getResource()) {
            jedis.del("teachers");
        }
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



