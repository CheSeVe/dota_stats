package ru.CheSeVe.lutiy_project.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class User {
    @Id
    Long userId;

    @Column(nullable = false, unique = true)
    String userName;

    @Column(nullable = false)
    String password;

    String rank;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    Set<Player> players = new HashSet<>();

    @Builder.Default
    Timestamp created = Timestamp.from(Instant.now());

    public void addPlayer(Player player) {
        players.add(player);
        player.setUser(this);
    }

    public void removePlayer(Player player) {
        players.remove(player);
        player.setUser(null);
    }

    public User(Long steamId, String userName, String password, String rank) {

        this.userName = userName;

        this.password = password;

        this.rank = rank;

        this.userId = steamId;

    }
}
