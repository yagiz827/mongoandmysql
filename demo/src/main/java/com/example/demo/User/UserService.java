package com.example.demo.User;

import com.example.demo.Tournament.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    private final UserRepository usr;
    @Autowired
    public UserService(UserRepository usr) {
        this.usr = usr;
    }


    public List<User> GetUserRequest(){


        return usr.findAll();
    }
    public User CreateUserRequest(){
        User newUser= new User();
        usr.save(newUser);
        return newUser;
    }
    public User UpdateLevelRequest(User userToBeUpdated) {
        int currentLevel = userToBeUpdated.getLevel();
        int currentCoins = userToBeUpdated.getCoins();
        userToBeUpdated.setLevel(currentLevel + 1);
        userToBeUpdated.setCoins(currentCoins + 25);
        usr.save(userToBeUpdated);
        return userToBeUpdated;
    }
    public User UpdateScoreRequest(User userToBeUpdated) {
        int CurrentScore= userToBeUpdated.getTournament_score();
        userToBeUpdated.setTournament_score(CurrentScore +1);
        usr.save(userToBeUpdated);
        return userToBeUpdated;
    }
    public User UpdateCoinsRequest(User userToBeUpdated,boolean firstplace) {
        if(firstplace){
            int current=userToBeUpdated.getCoins();
            userToBeUpdated.setCoins(current+10000);
        }
        else{
            int current=userToBeUpdated.getCoins();
            userToBeUpdated.setCoins(current+5000);
        }
        usr.save(userToBeUpdated);
        return userToBeUpdated;
    }

/*
    public User UpdateLevelRequest(){
        return
    }
    public User DeleteUserRequest(int id){
        usr.findById(id).remo
        return usr.DeleteUserRequest
    }*/
}
