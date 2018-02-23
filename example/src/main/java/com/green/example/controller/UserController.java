package com.green.example.controller;

import com.green.example.entities.User;
import com.green.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public ModelAndView listUsers() {
        ModelAndView model = new ModelAndView();
        model.setViewName("user/list");

        List<User> users = userService.findAllUsers();
        model.addObject("users", users);
        model.addObject("loggedinuser", getPrincipal());
        return model;
    }

    @RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "user/registration";
    }

    @RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result,
                           ModelMap model) {

        if (result.hasErrors()) {
            return "user/registration";
        }

        if(!userService.isUserUnique(user.getUserName())){
            FieldError ssoError =new FieldError("user","userName", messageSource.getMessage("user.unique.userName", new String[]{user.getUserName()}, Locale.getDefault()));
            result.addError(ssoError);
            return "user/registration";
        }

        userService.saveUser(user);

        model.addAttribute("success", "User " + user.getFullName() + " registered successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
        return "user/registrationsuccess";
    }

    @RequestMapping(value = { "/edit-user-{userName}" }, method = RequestMethod.GET)
    public String editUser(@PathVariable String userName, ModelMap model) {
        User user = userService.findByUserName(userName);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "user/registration";
    }

    @RequestMapping(value = { "/edit-user-{userName}" }, method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result,
                             ModelMap model, @PathVariable String userName) {

        if (result.hasErrors()) {
            return "user/registration";
        }

        userService.updateUser(userName, user);

        model.addAttribute("success", "User " + user.getFullName() + " updated successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "user/registrationsuccess";
    }

    @RequestMapping(value = { "/delete-user-{ssoId}" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String ssoId) {
        userService.deleteUser(ssoId);
        return "redirect:/user/list";
    }

//
//    @ModelAttribute("roles")
//    public List<Role> initializeProfiles() {
//        return userProfileService.findAll();
//    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
