package ru.CheSeVe.lutiy_project.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
import java.time.Instant;


@Entity
@Table(name = "heroes")
@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Hero {
    @Id
    String heroName;

    @Builder.Default
    Timestamp created = Timestamp.from(Instant.now());

    public Hero(String heroName) {
        this.heroName = heroName;
    }

}
