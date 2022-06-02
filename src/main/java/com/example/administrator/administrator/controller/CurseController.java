package com.example.administrator.administrator.controller;

import com.example.administrator.administrator.model.ModelCurse;
import com.example.administrator.administrator.model.ModelPupil;
import com.example.administrator.administrator.service.CurseService;
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
@RequestMapping("/curseController")
public class CurseController {

    @Autowired
    @Qualifier("CurseServiceImpl")
    CurseService curseService;

    @GetMapping("/addCurse")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("addcurse");
        mav.addObject("curse",new ModelCurse());
        return mav;
    }

    @PostMapping("/add")
    public RedirectView addCurse(@ModelAttribute("curse")ModelCurse modelCurse){
    curseService.addCurse(modelCurse);
    return new RedirectView("/curseController/curseList");
    }

    @GetMapping("/curseList")
    public ModelAndView getCurseList(){
        ModelAndView mav = new ModelAndView("gestionusuarios");
        mav.addObject("curses",curseService.getAllCurses());
        return mav;
    }

}
