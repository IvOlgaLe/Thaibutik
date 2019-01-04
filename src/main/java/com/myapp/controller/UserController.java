package com.myapp.controller;

import com.myapp.enums.Constants;
import com.myapp.model.User;
import com.myapp.service.CartService;
import com.myapp.service.UserService;
import com.myapp.utils.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @Autowired
    CartService cartService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView login(@ModelAttribute("user") User user) {
        return new ModelAndView("login");
    }

    @RequestMapping("processLogout")
    public String processLogout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            session = null;
        }
        return "redirect:/";
    }

    @RequestMapping("processLogin")
    public String processLogin(@ModelAttribute("user") User user, HttpServletRequest request, RedirectAttributes redir) {
        List<Exception> exceptionList = new ArrayList<>();
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        user = userService.validateUser(email, password);
        if (user != null) {
            if(userService.checkAdminPrivilege(user)) {
                session.setAttribute("adminFlag", true);
            }
            session.setAttribute("sessUser", user);
            session.setAttribute("cart", cartService.mergeLoginUserCarts(session, exceptionList));
        } else {
            redir.addFlashAttribute("errorLoginMessage", "Wrong credentials");
            redir.addFlashAttribute("email", email);
            return "redirect:/login";
        }
        return "redirect:/index";
    }

    @Transactional
    @RequestMapping(value = "processRegister", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute("user") @Valid User user, BindingResult result, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (!result.hasErrors()) {
            //if user is registered with that email
            if (userService.getUserByEmail(user.getEmail()) != null) {
                request.setAttribute("errorRegisterMessage", "User with email " + user.getEmail() + " is registered");
                request.setAttribute("email", user.getEmail());
                return "forward:/login";
            }
           // int roleId = cacheManager.getEnumIdByName(MemoryCache.ROLE.getName(), Constants.ROLE_USER);
            int roleId = userService.getRoleByName(Constants.ROLE_USER).getId();
            if (roleId != 0) {
                user.setRoleId(roleId);
                userService.saveUser(user);
                session.setAttribute("sessUser", user);
                return "redirect:/index";
            }
            return "redirect:/index";
        } else {
            return "forward:/login";
        }
    }

    @RequestMapping(value = "adminDashboard", method = RequestMethod.GET)
    public ModelAndView adminDashboard() {
        return new ModelAndView("admin_dashboard");
    }

    @RequestMapping(value = "myAccount", method = RequestMethod.GET)
    public ModelAndView myAccountPage(@ModelAttribute("user") User user) {
        return new ModelAndView("my_account");
    }

    @RequestMapping(value = "profileForm", method = RequestMethod.GET)
    public ModelAndView profileFormPage(@ModelAttribute("user") User user) {
        return new ModelAndView("profile_form");
    }

    @RequestMapping(value = "profilePassword", method = RequestMethod.GET)
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

    @RequestMapping(value = "passwordRestore", method = RequestMethod.GET)
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
