package com.example.demo.space;

import com.example.demo.User.User;
import com.example.demo.mongooo.MRepo;
import com.example.demo.mongooo.MTournament;
import lombok.AllArgsConstructor;
import com.example.demo.mongooo.MTournament;
import com.example.demo.mongooo.MRepo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@AllArgsConstructor
public class SpaceService {

    private final MRepo repo;

    public void createAlienAndSpaceShip(String alienname){

        MTournament g =new MTournament();
        repo.insert(g);
    }
    public void fetchadnupdate(MTournament mt,User user){
        var t=repo.findById(mt.getId());
        var q =t.get();
        User h=new User();
        h.setId(user.getId());
        h.setCoins(user.getCoins());
        h.setLevel(user.getLevel());
        h.setCountry(user.getCountry());
        Map<String, List<User>> UserCountryList= new HashMap<>();
        UserCountryList.put("Germany",q.getGrList());
        UserCountryList.put("Turkey",q.getTrList());
        UserCountryList.put("the United Kingdom",q.getUkList());
        UserCountryList.put("the United States",q.getUsList());
        UserCountryList.put("France",q.getFrList());
        var list=UserCountryList.get(h.getCountry());
        //var y=q.getFrList();
        //y.add(h);
        list.add(h);
        repo.save(q);
    }
    /*var t=repo.findById(mt.getId());
    var q =t.get();
    User h=new User();
    var y=q.getFrList();
    y.add(h);
    repo.save(q);
*/
}