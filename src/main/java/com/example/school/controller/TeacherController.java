package com.example.school.controller;


import com.example.school.model.Teacher;
import com.example.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/visit")
public class TeacherController {
    @Autowired
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public String showHtml() {
        return "visit";
    }

    @GetMapping("/main")
    public String getAllTeachers(Model model) {
        List<Teacher> list = teacherService.findAllTeachers();
        System.out.println("Учителей в базе: " + list.size()); // добавь лог
        model.addAttribute("teachers", list);
        return "visit";
    }









    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("user", new Teacher());
        return "/add";
    }

    @PostMapping("/add")
    public String addTeacher(@ModelAttribute Teacher teacher) {

        teacherService.addTeacher(teacher);
        return "redirect:/visit";
    }






}
