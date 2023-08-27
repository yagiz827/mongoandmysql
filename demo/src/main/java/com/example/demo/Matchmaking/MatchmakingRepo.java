package com.example.demo.Matchmaking;

import com.example.demo.Tournament.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchmakingRepo extends JpaRepository<Matchmaking, Integer> {
}
