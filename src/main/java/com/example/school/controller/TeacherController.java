package com.example.school.controller;


import com.example.school.model.Teacher;
import com.example.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/visit")
public class TeacherController {
    @Autowired
    private final TeacherService teacherService;

    private final TeacherService teacherService2;

    public TeacherController(TeacherService teacherService, TeacherService teacherService2) {
        this.teacherService = teacherService;
        this.teacherService2 = teacherService2;
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


    @GetMapping("/delete")
    public String showDeleteForm(Model model) {
        model.addAttribute("teachers", teacherService.findAllTeachers());
        return "/delete";
    }
    @Transactional
    @PostMapping("/delete")
    public String deleteTeacher(@RequestParam String name) {
        teacherService.deleteTeacherByName(name);
        return "redirect:/visit/delete";
    }


    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("user", new Teacher());
        return "/add";
    }

    @PostMapping("/add")
    public String addTeacher(@ModelAttribute Teacher teacher) {

        teacherService.addTeacher(teacher);
        return "redirect:/visit/main";
    }


}
