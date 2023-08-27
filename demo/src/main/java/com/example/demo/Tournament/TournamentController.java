package com.example.demo.Tournament;

import com.example.demo.Matchmaking.Matchmaking;
import com.example.demo.Matchmaking.MatchmakingService;
import com.example.demo.User.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping(path = "api/v1/Tournament")
public class TournamentController {


    private final TournamentService ts;
    private final MatchmakingService ms;

    @Autowired
    public TournamentController(TournamentService ts, MatchmakingService ms) {
        this.ts = ts;
        this.ms = ms;
    }
    @GetMapping
    public List<Tournament> GetTournaments(){
        return ts.GetTournaments();
    }
    @GetMapping(path="CountryLeaderboard")
    public List<User> getLeaderBoard(@RequestParam(name = "CountryName") String Countryname){
        return ts.getLeaderBoard(Countryname);
    }

    @PostMapping
    public Tournament CreateTournamentRequest(){
        return ts.CreateTournamentRequest();
    }
    @PostMapping(path="EnterTournament")
    public Boolean EnterTournamentRequest(@RequestBody User user, @RequestParam(name = "Tournament_id") int Tournament_id){
        Matchmaking newm=new Matchmaking();
        if(ts.EnterTournamentRequest(user, Tournament_id)){
            newm=ts.CreateMatchmakingRequest(Tournament_id);
        }
        ms.StartMatchmaking(newm.id);
        return Boolean.TRUE;
    }
}
