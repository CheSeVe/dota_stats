package ru.CheSeVe.lutiy_project.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(nullable = false, unique = true)
    String userName;

    @Column(nullable = false)
    String password;

    Integer mmr;

    Long steamId;

    @Builder.Default
    Instant created = Instant.now();

    public User(String userName, String password, Integer mmr, Long steamId) {

        this.userName = userName;

        this.password = password;

        this.mmr = mmr;

        this.steamId = steamId;

    }
}
