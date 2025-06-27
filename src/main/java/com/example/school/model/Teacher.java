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
    private String last_name;
    private int age;



    public Teacher(String name, String last_name, int age) {
        this.age = age;
        this.name = name;
        this.last_name = last_name;
    }


    public Teacher() {

    }
}
