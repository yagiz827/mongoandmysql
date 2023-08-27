package com.example.demo.Matchmaking;

import com.example.demo.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/MatchMaking")
public class MatchmakingController {
    private final MatchmakingService ms;
    @Autowired
    public MatchmakingController(MatchmakingService ms) {
        this.ms = ms;
    }

    @PostMapping
    public void StartMatchmaking(@RequestParam(name = "matchmakingid") int matchmakingid){
        ms.StartMatchmaking( matchmakingid);
    }

    @GetMapping(path="GroupLeaderboard")
    public List<User> getLeaderBoard(@RequestParam(name = "group_id") int group_id){
        return ms.getGroupBoard(group_id);
    }
}
