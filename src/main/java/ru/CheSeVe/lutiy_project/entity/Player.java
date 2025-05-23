package ru.CheSeVe.lutiy_project.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Table(name = "players")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long userId;

    @Column(nullable = false)
    Boolean hasWon;

    @Column(nullable = false)
    Long steamId;

    @ManyToOne(fetch = FetchType.LAZY)
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    Match match;

    @Builder.Default
    List<String> items = new ArrayList<>();

    @Builder.Default
    Timestamp created = Timestamp.from(Instant.now());

    public Player(Boolean hasWon, Long steamId, Match match, User user) {
        this.hasWon = hasWon;
        this.steamId = steamId;
        this.user = user;
        this.match = match;
    }

    public void addItem(String itemName) {
        items.add(itemName);
    }

    public void removeItem(String itemName) {
        items.remove(itemName);
    }
}
