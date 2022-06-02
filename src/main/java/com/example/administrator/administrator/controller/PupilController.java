package com.example.administrator.administrator.controller;

import com.example.administrator.administrator.model.ModelCurse;
import com.example.administrator.administrator.model.ModelPupil;
import com.example.administrator.administrator.service.CurseService;
import com.example.administrator.administrator.service.PupilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/pupilController")
public class PupilController {

    @Autowired
    @Qualifier("PupilServiceImpl")
    PupilService pupilService;

    @Autowired
    @Qualifier("CurseServiceImpl")
    CurseService curseService;


    @GetMapping("/addPupil")
    public ModelAndView login(Model model){
        ModelAndView mav = new ModelAndView("addpupil");
        List<ModelCurse> modelCurses = curseService.getAllCurses();
        mav.addObject("pupil",new ModelPupil());
        mav.addObject("curses",modelCurses);
        return mav;
    }

    @PostMapping("/add")
    public RedirectView addPupil(@ModelAttribute("pupil")ModelPupil modelPupil){
        pupilService.addPupil(modelPupil);
        return new RedirectView("/pupilController/pupilList");
    }

    @GetMapping("/pupilList")
    public ModelAndView getPupilList(){
        ModelAndView mav = new ModelAndView("pupilList");
        mav.addObject("pupils",pupilService.getAllPupils());
        return mav;
    }

}
