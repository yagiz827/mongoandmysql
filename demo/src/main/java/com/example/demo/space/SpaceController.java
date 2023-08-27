package com.example.demo.space;

import com.example.demo.User.User;
import com.example.demo.mongooo.MTournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/space")
public class SpaceController {
    private final SpaceService ss;

    @Autowired
    public SpaceController(SpaceService ss) {
        this.ss = ss;
    }

    @PostMapping()
    public void createAlienAndSpaceShip(){
        String h="asd";
        ss.createAlienAndSpaceShip(h);
    }

    public void fetchadnupdate(MTournament mt, User user){
        ss.fetchadnupdate(mt,user);
    }
}
