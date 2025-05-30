package ru.CheSeVe.lutiy_project.dto;

import jakarta.persistence.*;
import lombok.*;
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
public class MatchDto {
    @NonNull
    Long matchId;

    @NonNull
    Set<MatchUser> matchUsers;

    Instant created = Instant.now();
}
