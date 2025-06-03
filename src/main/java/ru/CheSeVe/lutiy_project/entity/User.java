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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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


    public User(String userName, String password) {

        this.userName = userName;

        this.password = password;

        matchUsers = new HashSet<>();

        created = Instant.now();
    }

    public void addMatchUser(MatchUser matchUser) {
        matchUsers.add(matchUser); //добавлять матчюзера в сет не надо, т.к. будет приходить уже готовый сет
    }

    public void removeMatchUser(MatchUser matchUser) {
        matchUsers.remove(matchUser); // не уверен, что нужно убирать матчюзера из матча
    }

}
