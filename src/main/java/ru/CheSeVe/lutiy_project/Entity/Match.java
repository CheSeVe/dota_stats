package ru.CheSeVe.lutiy_project.Entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "matches")
public class Match {
    private long matchId;
    private Set<User> players; //хз как правильно сделать, в матче должна хранится информация об игроках, которые в нем участвовали
    private List<Item> items; //такая же хуйня
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
