package com.example.demo.Tournament;
import com.example.demo.Matchmaking.Matchmaking;
import com.example.demo.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Integer>  {
    @Query("SELECT Country,tournament_score from User u where u.Country=?1 ORDER BY tournament_score DESC")
    List<User> CountryLeaderboard(String CountryName );
}
