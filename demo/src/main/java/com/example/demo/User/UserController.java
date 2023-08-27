package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/User")
public class UserController {
    private final UserService us;

    @Autowired
    public UserController(UserService us) {
        this.us = us;
    }

    @GetMapping
    public List<User> GetUserRequest(){
        return us.GetUserRequest();
    }

    @PostMapping
    public User CreateUserRequest(){
        return us.CreateUserRequest();
    }
    @PostMapping(path="updateLevel")
    public User UpdateLevelRequest(@RequestBody User user){
        return us.UpdateLevelRequest(user);
    }@PostMapping(path="updateScore")
    public User UpdateScoreRequest(@RequestBody User user){
        return us.UpdateLevelRequest(user);
    }
    /*@DeleteMapping(path="{UserId}")
    public User DeleteUserRequest(@PathVariable("UserId") int id){
        return us.DeleteUserRequest(id);
    }

    @GetMapping
    public User UpdateLevelRequest(){
        return us.UpdateLevelRequest();
    }*/

}
