package com.example.administrator.administrator.controller;

import com.example.administrator.administrator.model.ModelPupil;
import com.example.administrator.administrator.model.ModelTeacher;
import com.example.administrator.administrator.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/teacherController")
public class TeacherController {


    @Autowired
    @Qualifier("TeacherServiceImpl")
    TeacherService teacherService;

    @PostMapping("/addPupil")
    public RedirectView addPupil(@ModelAttribute("teacher") ModelTeacher modelTeacher){
        teacherService.addTeacher(modelTeacher);
        return new RedirectView("/teacherController/pupilList");
    }

    @GetMapping("/pupilList")
    public ModelAndView getPupilList(){
        ModelAndView mav = new ModelAndView("teacherList");
        mav.addObject("teachers",teacherService.getAllTeachers());
        return mav;
    }
}
