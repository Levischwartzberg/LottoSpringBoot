package com.example.demo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Game {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_id")
    private Integer Id;

    @Version
    private Integer version;

    private String gameName;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<State> stateList;


    public Game() {};

    public List<State> getStateList() {
        return stateList;
    }

    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }

    public Game(String gameName) {
        this.gameName = gameName;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
}
