package com.example.travelbackend.Service;

import com.example.travelbackend.Entity.User;
import com.example.travelbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository ;

    public User CreateUser(User user) {
        return userRepository.save(user) ;
    }
    public User updateUser(User user) {
        return userRepository.save(user) ;
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public User getUserbyId(Long id) {return userRepository.findById(id).get();}
    public List<User> getAllUsers() {return userRepository.findAll();}
}
