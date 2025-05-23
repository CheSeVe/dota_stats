package ru.CheSeVe.lutiy_project.dto;

import jakarta.persistence.ManyToMany;
import lombok.*;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;

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

    String rank;

    Timestamp created = Timestamp.from(Instant.now());

}
