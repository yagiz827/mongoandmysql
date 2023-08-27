package com.example.demo.mongooo;


import com.example.demo.User.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class MTournament {
    /*@Id
    private String id;
    private String name;
    private Double height;
    private Double weight;*/
    @Id
    public String id;

    public List<User> UkList;

    public List<User> UsList;

    public List<User> TrList;

    public List<User> FrList;

    public List<User> GrList;
    public MTournament() {
        UkList = new ArrayList<User>();
        UsList = new ArrayList<User>();
        TrList = new ArrayList<User>();
        FrList = new ArrayList<User>();
        GrList = new ArrayList<User>();
    }

}