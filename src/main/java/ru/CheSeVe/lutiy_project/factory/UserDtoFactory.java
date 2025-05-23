package ru.CheSeVe.lutiy_project.factory;

import org.springframework.stereotype.Component;
import ru.CheSeVe.lutiy_project.dto.UserDto;
import ru.CheSeVe.lutiy_project.entity.User;

@Component
public class UserDtoFactory {
    public UserDto createUserDto(User user) {
        return UserDto.builder()
                .id(user.getUserId())
                .userName(user.getUserName())
                .password(user.getPassword())
                .rank(user.getRank()).build();

    }
}
