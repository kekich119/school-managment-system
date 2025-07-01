package com.example.school.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "teacher")
@Data
public class Teacher {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String subject;


    private String lastName; // ✅ БЫЛО: last_name

    private int age;

    public Teacher(String name, String lastName, int age, String subject) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.subject = subject;
    }

    public Teacher() {}
}