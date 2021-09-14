package com.example.demo;

import javax.persistence.*;

@Entity
public class Prize {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prize_id")
    private Integer Id;

    @Version
    private Integer version;

    private String winningNumbers;
    private String prizeAmount;
    private String odds;

    @ManyToOne
    private Game game;

    public Prize() {}

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

    public String getOdds() {
        return odds;
    }

    public void setOdds(String odds) {
        this.odds = odds;
    }

    public String getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(String winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public String getPrizeAmount() {
        return prizeAmount;
    }

    public void setPrizeAmount(String prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
