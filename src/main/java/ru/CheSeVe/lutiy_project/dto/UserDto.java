package ru.CheSeVe.lutiy_project.dto;

import lombok.*;
import lombok.Builder;
import lombok.experimental.FieldDefaults;
import ru.CheSeVe.lutiy_project.entity.MatchUser;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    @NonNull
    Long userId;

    @NonNull
    String userName;

    @NonNull
    String password;

    String rank;

    Set<MatchUser> matchUsers;

    Instant created;

}
