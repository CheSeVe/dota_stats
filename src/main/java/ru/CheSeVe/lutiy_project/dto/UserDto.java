package ru.CheSeVe.lutiy_project.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    @NonNull
    Long id;

    @NonNull
    String userName;

    @NonNull
    String password;

    private Integer mmr;

    private Long steamId;

    Instant created = Instant.now();
}
