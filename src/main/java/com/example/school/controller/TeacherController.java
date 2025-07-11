package com.example.school.controller;


import com.example.school.model.Teacher;
import com.example.school.service.TeacherService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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



    @GetMapping("/delete")
    public String showDeleteForm(Model model) {
        model.addAttribute("teachers", teacherService.findAllTeachers());
        return "/delete";
    }

    @Transactional
    @PostMapping("/delete")

    public String deleteTeacher(@RequestParam String name, RedirectAttributes redirectAttributes) {
        boolean isLive = teacherService.existsByName(name);
        if (isLive) {
            teacherService.deleteTeacherByName(name);
        } else {
            redirectAttributes.addFlashAttribute("error", "Такого имени нет");
        }
        return "redirect:/visit/delete";
    }


    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("user", new Teacher());
          return "/add" ;
    }





    @PostMapping("/add")

    public String addTeacher(@ModelAttribute  Teacher teacher, RedirectAttributes redirectAttributes) {
        boolean isLive = teacherService.existsByName(teacher.getName());
        if (isLive) {
            redirectAttributes.addFlashAttribute("error", "Такое имя уже есть! Повторите попытку");
            redirectAttributes.addFlashAttribute("user", teacher); // чтобы заполнить форму снова
            return "redirect:/visit/add";
        } else {
            teacherService.addTeacher(teacher);
            return "redirect:/visit/main";
        }

    }

    @GetMapping("/filter")
    public String showFilterForm(Model model, @RequestParam String subject, RedirectAttributes redirectAttributes) {

        List<Teacher> allTeachers = teacherService.findAllTeachers();
        List<Teacher> list = teacherService.filterTeacherBySubject(subject);
        if (allTeachers.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Учителей нет в базе данных");
            return "redirect:/visit/filter";
        }else {
            model.addAttribute("teachers", list);
            return "filter";
        }

    }
}
