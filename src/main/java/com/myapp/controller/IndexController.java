package com.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
@SessionAttributes("userkey")
public class IndexController {

    //Day2
    @RequestMapping("/")
    public ModelAndView indexPage(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("Index");
        return mav;
    }
}
