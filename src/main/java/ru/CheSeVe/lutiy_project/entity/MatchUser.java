package ru.CheSeVe.lutiy_project.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.CheSeVe.lutiy_project.enums.Hero;
import ru.CheSeVe.lutiy_project.enums.Item;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "match_users")
public class MatchUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long matchUserId;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    List<Item> items = new ArrayList<>();

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    Hero hero;

    @Column(nullable = false)
    Long steamId;

    @Column(nullable = false)
    Boolean hasWon;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "match_id")
    Match match;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    User user;

    public MatchUser(Hero hero, Long steamId, Boolean hasWon, Match match, User user) {
        this.hero = hero;

        this.steamId = steamId;

        this.hasWon = hasWon;

        this.match = match;

        this.user = user;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
}
