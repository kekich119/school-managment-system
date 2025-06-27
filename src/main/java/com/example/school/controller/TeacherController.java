package com.example.school.controller;


import com.example.school.model.Teacher;
import com.example.school.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/visit")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    public String showHtml(){
        return "visit";
    }

    @GetMapping
    public List<Teacher> findAllTeachers(Model model) {

        model.addAttribute("teacher", teacherService.findAllTeachers().toString());
        return teacherService.findAllTeachers();

    }


    @GetMapping("/add")
    public String addTeacher(@ModelAttribute Teacher teacher) {
        teacherService.addTeacher(teacher);
        return "teacher/add";

    }


}
