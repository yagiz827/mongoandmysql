package com.example.demo.Tournament;



import com.example.demo.Matchmaking.Matchmaking;
import com.example.demo.User.User;
import com.example.demo.User.UserRepository;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.*;
@Data
@Entity
@Table
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public  int id;
    @Column
    public Date sysdate;
    @OneToMany(mappedBy = "tournament")
    public List<Matchmaking> GroupList;

    @OneToMany(mappedBy = "tournament")
    public List<User> UserList;

    public Tournament() {
        UserList=new ArrayList<User>();
        GroupList=new ArrayList<Matchmaking>();
        sysdate= Date.from(Instant.now());
    }
}