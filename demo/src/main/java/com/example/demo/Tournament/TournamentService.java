package com.example.demo.Tournament;
import com.example.demo.Matchmaking.Matchmaking;
import com.example.demo.Matchmaking.MatchmakingRepo;
import com.example.demo.User.User;

import com.example.demo.User.UserRepository;

import com.example.demo.mongooo.MRepo;
import com.example.demo.mongooo.MTournament;
import com.example.demo.space.SpaceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@AllArgsConstructor
@Service
public class TournamentService {
    boolean CanJoin(User user){
        return (user.Claimed) && (user.getLevel() >= 20) && (user.getCoins() >= 10000);
    }
    private final TournamentRepository tsr;

    private final SpaceService ss;
    @Autowired
    public TournamentService(TournamentRepository tsr, SpaceService ss) {
        this.tsr = tsr;
        this.ss = ss;
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MRepo mongoRepository;
    @Autowired
    private MatchmakingRepo mrp;



    public List<Tournament> GetTournaments(){
        return tsr.findAll();
    }
    public Tournament CreateTournamentRequest(){
        Tournament newT=new Tournament();
        tsr.save(newT);
        MTournament newMT=new MTournament();
        mongoRepository.save(newMT);
        return newT;
    }
    public Matchmaking CreateMatchmakingRequest(int id){
        List<List> loopList=new ArrayList<List>();
        MTournament mt = mongoRepository.findAll().get(id-1);
        Matchmaking newM=new Matchmaking();
        loopList.add(mt.getGrList());
        loopList.add(mt.getFrList());
        loopList.add(mt.getUkList());
        loopList.add(mt.getTrList());
        loopList.add(mt.getUsList());
        newM.setFrId(mt.getFrList().get(0).getId());
        newM.setGrId(mt.getGrList().get(0).getId());
        newM.setTrId(mt.getTrList().get(0).getId());
        newM.setUkId(mt.getUkList().get(0).getId());
        newM.setUsId(mt.getUsList().get(0).getId());
        for (var l: loopList
        ) {
            l.remove(0);
        }
        mongoRepository.save(mt);
        Optional<Tournament> tournamentobeadded=tsr.findById(id);
        Tournament tournament=tournamentobeadded.get();
        newM.setTournament(tournament);
        mrp.save(newM);
        return newM;
    }

    public Boolean EnterTournamentRequest(User user,int Tournament_id){
        Optional<Tournament> tournamentobeadded=tsr.findById(Tournament_id);
        System.out.println(mongoRepository.findAll());
        MTournament Mtournament = mongoRepository.findAll().get(Tournament_id-1);
        if(tournamentobeadded.isPresent())
        {
            List<List> loopList=new ArrayList<List>();

            Tournament tournament=tournamentobeadded.get();
            List<User> toBeAdded=tournament.UserList;
            toBeAdded.add(user);
            user.setTournament(tournament);
            userRepository.save(user);
            tsr.save(tournament);
            ss.fetchadnupdate(Mtournament, user);
            loopList.add(Mtournament.getGrList());
            loopList.add(Mtournament.getFrList());
            loopList.add(Mtournament.getUkList());
            loopList.add(Mtournament.getTrList());
            loopList.add(Mtournament.getUsList());
            for (var t:loopList
                 ) {
                if(t.size()==0){
                    return Boolean.FALSE;
                }
            }
            return Boolean.TRUE;
        }
        throw new RuntimeException();
    }

    public List<User> getLeaderBoard(String Name){
        return tsr.CountryLeaderboard(Name);
    }
}
