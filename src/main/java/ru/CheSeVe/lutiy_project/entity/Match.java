package ru.CheSeVe.lutiy_project.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "matches")
public class Match {
    private long matchId;
    private Set<User> players;
    private List<Item> items;
    public void setMatchId(long matchId) {
        this.matchId = matchId;
    }
    public long getMatchId() {
        return matchId;
    }

    public void setPlayers(Set<User> players) {
        this.players = players;
    }

    public Set<User> getPlayers() {
        return players;
    }
}
