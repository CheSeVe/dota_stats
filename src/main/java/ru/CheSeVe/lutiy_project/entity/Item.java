package ru.CheSeVe.lutiy_project.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
import java.time.Instant;


@Entity
@Table(name = "items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Item {
    @Id
    String itemName; //по хорошему убрать наверн, id = name, меняться не будет, вообще как final класс ебануть мб с редкими изменениями

    @Builder.Default
    Timestamp created = Timestamp.from(Instant.now());

    public Item(String itemName) {
        this.itemName = itemName;
    }

}
