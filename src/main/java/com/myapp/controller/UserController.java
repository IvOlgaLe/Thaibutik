package com.myapp.controller;

import com.myapp.cache.MemoryCache;
import com.myapp.enums.Constants;
import com.myapp.model.User;
import com.myapp.service.UserService;
import com.myapp.utils.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController extends BaseController {

    @Autowired
    UserService userService;

 /*   @Autowired
    MessageSource message;*/

    @RequestMapping(value = "Login", method = RequestMethod.GET)
    public ModelAndView login(@ModelAttribute("user") User user) {
        return new ModelAndView("login");
    }

    @RequestMapping("processLogout")
    public ModelAndView processLogout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            session = null;
        }
        return new ModelAndView("index");
    }

    @RequestMapping("processLogin")
    public ModelAndView processLogin(@ModelAttribute("user") User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        user = userService.validateUser(email, password);
        if (user != null) {
            session.setAttribute("sessUser", user);
        } else {
            request.setAttribute("errorMessage", "Wrong credentials");
            request.setAttribute("email", email);
            return new ModelAndView("login");
        }
        return new ModelAndView("index");
    }

/*    @RequestMapping(value = "register", method = RequestMethod.GET)
    public ModelAndView register(@ModelAttribute("user") User user) {
        return new ModelAndView("register", "user", user);
    }*/


    @Transactional
    @RequestMapping(value = "processRegister", method = RequestMethod.POST)
    public ModelAndView processRegister(@ModelAttribute("user") @Valid User user, BindingResult result, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (!result.hasErrors()) {
            int roleId = 1;//cacheManager.getEnumIdByName(MemoryCache.ROLE.getName(), Constants.ROLE_USER);
            if (roleId != 0) {
                user.setRoleId(roleId);
                userService.saveUser(user);
                session.setAttribute("sessUser", user);
                return new ModelAndView("index");
            }
            return new ModelAndView("error_page");
        } else {
            return new ModelAndView("login");
        }
    }

    @RequestMapping(value = "MyAccount", method = RequestMethod.GET)
    public ModelAndView myAccountPage(@ModelAttribute("user") User user) {
        return new ModelAndView("my_account");
    }

    @RequestMapping(value = "ProfileForm", method = RequestMethod.GET)
    public ModelAndView profileFormPage(@ModelAttribute("user") User user) {
        return new ModelAndView("profile_form");
    }

    @RequestMapping(value = "ProfilePassword", method = RequestMethod.GET)
    public ModelAndView profilePasswordPage(@ModelAttribute("user") User user) {
        return new ModelAndView("profile_password");
    }

    @Transactional
    @RequestMapping(value = "processModify", method = RequestMethod.POST)
    public ModelAndView processModify(@ModelAttribute("user") @Valid User user, BindingResult result, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (!result.hasErrors()) {
            userService.saveUser(user);
            session.setAttribute("sessUser", user);
            return new ModelAndView("my_account");
        } else {
            return new ModelAndView("profile_form");
        }
    }

    @Transactional
    @RequestMapping(value = "processModifyPassword", method = RequestMethod.POST)
    public ModelAndView processModifyPassword(@ModelAttribute("user") @Valid User user, BindingResult result, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User sessUser = (User) session.getAttribute("sessUser");
        String password = sessUser.getPassword();
        String tempPassword = request.getParameter("temporaryPassword");
        String inputPassword = request.getParameter("inputPassword");
        if (!result.hasErrors() && (inputPassword.equals(password) ||
                (tempPassword != null && tempPassword.equals(inputPassword)))) {
            userService.saveUser(user);
            session.setAttribute("sessUser", user);
            return new ModelAndView("my_account");
        } else {
            request.setAttribute("temporaryPassword", tempPassword);
            request.setAttribute("errorMessage", "Wrong Old / Temporary Password");
            return new ModelAndView("profile_password");
        }
    }

    @RequestMapping(value = "PasswordRestore", method = RequestMethod.GET)
    public ModelAndView passwordRestore(HttpServletRequest request) {
        // return new ModelAndView("password_restore");
        return new ModelAndView("password_restore");
    }

    @Transactional
    @RequestMapping(value = "processPasswordRestore", method = RequestMethod.POST)
    public ModelAndView processPasswordRestore(@ModelAttribute("user") User user, HttpServletRequest request) {
        String email = request.getParameter("email");
        String tempPassword = request.getParameter("temporaryPassword");
        user = userService.getUserByEmail(email);
        if (tempPassword != null) {
            String inputTempPassword = request.getParameter("inputTempPassword");
            if (inputTempPassword.equals(tempPassword)) {
                HttpSession session = request.getSession();
                session.setAttribute("sessUser", user);
                request.setAttribute("temporaryPassword", tempPassword);
                return new ModelAndView("profile_password");
            }
        } else if (user != null) {
            SendEmail emailManager = new SendEmail();
            tempPassword = "1@Qa";
            //   emailManager.execute(tempPassword, "Password restore from ThaiButik", user.getEmail());
            request.setAttribute("email", email);
            request.setAttribute("errorMessage", "Temporary Password has been sent to your email");
            request.setAttribute("temporaryPassword", tempPassword);
        } else {
            request.setAttribute("errorMessage", "User with this email doesn't exist");
        }
        return new ModelAndView("password_restore");
    }
}
