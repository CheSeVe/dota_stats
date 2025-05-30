package ru.CheSeVe.lutiy_project.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long matchId; //временно при создании генерируем, потом нужно будет подтягивать id матча с добабаффа/опендоты

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    @Builder.Default
    Set<MatchUser> matchUsers = new HashSet<>();

    @Builder.Default
    Instant created = Instant.now();
}
