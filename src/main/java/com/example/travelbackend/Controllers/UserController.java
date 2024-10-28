package com.example.travelbackend.Controllers;


import com.example.travelbackend.Entity.User;
import com.example.travelbackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/AddUser")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("UserForm", user);
        return "new_user";
    }



}
