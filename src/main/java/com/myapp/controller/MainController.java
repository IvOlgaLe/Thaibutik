package com.myapp.controller;

import com.myapp.model.User;
import com.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class MainController extends BaseController {

  /*  @Autowired
    UserService userService;
*//*
	@Autowired
	RoleService roleService;
	
	@Autowired
	OrderService orderService;*//*

    @Autowired
    MessageSource message;*/

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showMainPage() {
        return "mainPage";
    }

}
