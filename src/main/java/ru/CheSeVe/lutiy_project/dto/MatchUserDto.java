package ru.CheSeVe.lutiy_project.dto;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.CheSeVe.lutiy_project.entity.Match;
import ru.CheSeVe.lutiy_project.entity.User;
import ru.CheSeVe.lutiy_project.enums.Hero;
import ru.CheSeVe.lutiy_project.enums.Item;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MatchUserDto {

    @NonNull
    Long matchUserId;

    List<Item> items = new ArrayList<>();

    @NonNull
    Hero hero;

    @NonNull
    Long steamId;

    @NonNull
    Boolean hasWon;

    @NonNull
    Match match;

    // нужен ли @NonNull? юзер создается после добавления матчЮзера в бд?
    User user;
}
