package com.example.demo.User;

import com.example.demo.Tournament.Tournament;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.Data;

class CountryList{
    List<String> list;
    public  CountryList() {
        list=new ArrayList<String>();
        list.add("the United Kingdom");
        list.add("France");
        list.add("Germany");
        list.add("Turkey");
        list.add("the United States");
    }
}
@Data
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public  int id;
    @Column
    public int Level;
    @Column
    public  int Coins;
    @Column
    public String Country;
    @Column
    public Integer tournament_score;
    @Column(columnDefinition = "TINYINT(1)")
    public boolean Claimed;
    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    @JsonIgnore
    private Tournament tournament;



    public User() {

        Level = 1;
        Coins = 500;
        Claimed=Boolean.TRUE;
        tournament_score=0;
        CountryList C_list=new CountryList();
        Random rand = new Random();
        int ran_num= rand.nextInt(5);
        Country = C_list.list.get(ran_num);

    }

}
