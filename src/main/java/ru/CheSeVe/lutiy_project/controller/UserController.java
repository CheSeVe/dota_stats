package ru.CheSeVe.lutiy_project.controller;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.CheSeVe.lutiy_project.dto.UserDto;
import ru.CheSeVe.lutiy_project.entity.User;
import ru.CheSeVe.lutiy_project.exception.AlreadyExistException;
import ru.CheSeVe.lutiy_project.factory.UserDtoFactory;
import ru.CheSeVe.lutiy_project.repository.UserRepository;

@RestController
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserController {
    public final static String CREATE_USER = "user/create";
    public final static String UPDATE_USER = "user/update";
    public final static String DELETE_USER = "user/delete";
    public final static String GET_USER = "user/get";

    @Autowired
    UserDtoFactory userDtoFactory;

    @Autowired
    UserRepository userRepository;

    @Autowired
    Helper helper;

    @PostMapping(CREATE_USER)
    public UserDto createUser(@RequestParam(value = "user_name") String userName,
                              @RequestParam(value = "password") String password,
                              @RequestParam(value = "steamId") Long steamId,
                              @RequestParam(value = "mmr") Integer mmr) {
        userRepository.findOptionalUserName(userName).ifPresent(user -> {
            throw new AlreadyExistException(String.format("user already exist", userName));
        });
        User user = userRepository.saveAndFlush(new User(userName, password, mmr, steamId));
        userRepository.save(user);
        return userDtoFactory.createUserDto(user);
    }

}
