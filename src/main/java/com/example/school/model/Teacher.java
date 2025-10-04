package com.example.school.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "teachers_db")
@Data
public class Teacher {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private @NotNull @Size(min = 3, max = 10) String name;

    private @NotNull  String subject;


    private @NotNull @Size(min = 3, max = 10) String lastName; // ✅ БЫЛО: last_name

    private @NotNull int age;

    public Teacher(String name, String lastName, int age, String subject) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.subject = subject;
    }

    public Teacher() {
    }
}