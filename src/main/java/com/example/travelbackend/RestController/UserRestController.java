package com.example.travelbackend.RestController;

import com.example.travelbackend.Entity.User;
import com.example.travelbackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {
        @Autowired
        UserService userService;

        @PostMapping("/save")
        public User saveUser(@RequestBody User user) {
            return userService.CreateUser(user);
        }

        @GetMapping("/all")
        public List<User> getAllUsers() {

            return userService.getAllUsers();
        }
        @GetMapping("/getone/{id}")
        public User getUser(@PathVariable Long id) {
            return userService.getUserbyId(id);
        }
        @PutMapping("/update/{id}")
        public User updateUser(@PathVariable Long id, @RequestBody User user) {
            User u= userService.getUserbyId(id);
            if(u!=null) {
                user.setId(id);
                return userService.updateUser(user);
            }
            else {
                throw new RuntimeException("not found");}
        }
        @DeleteMapping("/user/{id}")
        public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
            try{
                userService.deleteUser(id);
                return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
            } catch (Exception e){
                return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
}
