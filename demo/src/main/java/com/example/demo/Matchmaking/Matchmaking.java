package com.example.demo.Matchmaking;

import com.example.demo.Tournament.Tournament;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Matchmaking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public  int id;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;
    @Column
    public Integer FrId;
    @Column
    public Integer UkId;
    @Column
    public Integer GrId;
    @Column
    public Integer TrId;
    @Column
    public Integer UsId;



}

