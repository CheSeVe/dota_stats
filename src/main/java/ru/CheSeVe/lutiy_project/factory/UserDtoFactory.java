package ru.CheSeVe.lutiy_project.factory;

import org.springframework.stereotype.Component;
import ru.CheSeVe.lutiy_project.dto.UserDto;
import ru.CheSeVe.lutiy_project.entity.User;

import java.sql.Timestamp;
import java.time.Instant;

@Component
public class UserDtoFactory {
    public UserDto createUserDto(User user) {
        return UserDto.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .password(user.getPassword())
                .rank(user.getRank())
                .matchUsers(user.getMatchUsers()).
                created(user.getCreated()).build();
    }
}
