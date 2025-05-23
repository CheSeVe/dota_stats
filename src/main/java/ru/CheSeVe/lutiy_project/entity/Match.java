package ru.CheSeVe.lutiy_project.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;


@Table(name = "matches")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Match {
    @Id
    Long matchId; //временно при создании указываем, потом нужно будет подтягивать id матча с добабаффа/опендоты

    @Builder.Default
    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, orphanRemoval=true)
    Set<Player> players = new HashSet<>();

    @Builder.Default
    Timestamp created = Timestamp.from(Instant.now());

    public void addPlayer(Player player) {
        players.add(player);
        player.setMatch(this);
    }

    public void removePlayer(Player player) {
        players.remove(player);
        player.setMatch(null);
    }


    public Match (Long matchId) {
        this.matchId = matchId;
    }
}
