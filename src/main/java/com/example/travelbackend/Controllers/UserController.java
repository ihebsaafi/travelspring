package com.example.travelbackend.Controllers;


import com.example.travelbackend.Entity.User;
import com.example.travelbackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
        public String saveUser(@ModelAttribute("UserForm") User user) {
            userService.CreateUser(user);
            return "redirect:/AllUser";
        }

        @RequestMapping("/AllUser")
        public String ListUser(Model model) {
            List<User> ListUsers= userService.getAllUsers();
            model.addAttribute("ListUsers", ListUsers);
            return "liste_users";
        }

        @GetMapping("deleteUser/{id}")
        public String deleteProduct(@PathVariable("id") long id) {
            userService.deleteUser(id);
            return "redirect:/AllUser";
        }

        @GetMapping("/editUser/{id}")
        public String showUpdateForm(@PathVariable("id") long id, Model model) {
            User user = userService.getUserbyId(id);
            model.addAttribute("user", user);
            return "update_user";
        }

        @PostMapping("/updateUser/{id}")
        public String updateUser(@PathVariable("id") long id, User user) {
            userService.updateUser(user);
            return "redirect:/AllUser";
        }










}
