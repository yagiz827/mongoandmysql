package com.example.demo.Matchmaking;


import com.example.demo.User.User;
import com.example.demo.User.UserRepository;
import com.example.demo.User.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
@AllArgsConstructor
public class MatchmakingService {
    @Autowired
    private MatchmakingRepo mrp;
    @Autowired
    private UserRepository userrepo;
    @Autowired
    private UserService userService;

    public void StartMatchmaking(int matchmakingid) {
        Matchmaking GetResults;
        GetResults = mrp.findAll().get(matchmakingid-1);
        List<Integer> UserElemination = new ArrayList<Integer>();
        UserElemination.add(GetResults.getFrId());
        UserElemination.add(GetResults.getUkId());
        UserElemination.add(GetResults.getUsId());
        UserElemination.add(GetResults.getGrId());
        UserElemination.add(GetResults.getTrId());
        while (UserElemination.size() != 1) {
            Random rand = new Random();
            int ran_num = rand.nextInt(UserElemination.size());
            UserElemination.remove(ran_num);//remove user from the group as it has lost
            for (var t : UserElemination
            ) {
                User updatelevel = userrepo.findById(t).get();
                //userService.UpdateLevelRequest(updatelevel);
                userService.UpdateScoreRequest(updatelevel);//update the user score of the remaining users
            }
            if (UserElemination.size() == 2) {
                User firstplace;
                User secondplace;
                Random rand2 = new Random();
                int ran_num2 = rand.nextInt(2);
                firstplace = userrepo.findById(UserElemination.get(ran_num2)).get();
                userService.UpdateScoreRequest(firstplace);
                secondplace = userrepo.findById(UserElemination.get(1 - ran_num2)).get();
                userService.UpdateCoinsRequest(firstplace, true);
                userService.UpdateCoinsRequest(secondplace, false);
                break;
            }
        }

    }

    public List<User> getGroupBoard(int group_id){
        Matchmaking GetResults;
        GetResults = mrp.findById(group_id).get();
        List<User> UserList = new ArrayList<User>();
        UserList.add(userrepo.findById(GetResults.getFrId()).get());
        UserList.add(userrepo.findById(GetResults.getGrId()).get());
        UserList.add(userrepo.findById(GetResults.getUkId()).get());
        UserList.add(userrepo.findById(GetResults.getUsId()).get());
        UserList.add(userrepo.findById(GetResults.getTrId()).get());
        Collections.sort(UserList, Comparator.comparingInt(User::getTournament_score).reversed());
        return UserList;
    }
}