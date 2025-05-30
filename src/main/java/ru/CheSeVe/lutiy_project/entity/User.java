package ru.CheSeVe.lutiy_project.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
    Long userId; // = steamId

    @Column(nullable = false, unique = true)
    String userName;

    @Column(nullable = false)
    String password;

    String rank;

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    Set<MatchUser> matchUsers = new HashSet<>();

    @Builder.Default
    Instant created = Instant.now();

        public User(Long steamId, String userName, String password, String rank) {

            this.userId = steamId;

            this.userName = userName;

            this.password = password;

            this.rank = rank;

            matchUsers = new HashSet<>();

            created = Instant.now();
        }

    public User(Long steamId, String userName, String password) {

        this.userName = userName;

        this.password = password;

        this.userId = steamId;

        matchUsers = new HashSet<>();

        created = Instant.now();
    }
}
