package ru.CheSeVe.lutiy_project.controller;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.CheSeVe.lutiy_project.dto.UserDto;
import ru.CheSeVe.lutiy_project.entity.User;
import ru.CheSeVe.lutiy_project.exception.AlreadyExistException;
import ru.CheSeVe.lutiy_project.exception.NotFoundException;
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
                              @RequestParam(value = "rank") String rank,
                              @RequestParam(value = "id") Long steamId) {
        userRepository.findByUserName(userName).ifPresent(user -> {
            throw new AlreadyExistException(String.format("user already exist", userName));
        });
        userRepository.findById(steamId).ifPresent(user -> {
            throw new AlreadyExistException(String.format("user already exist", steamId));
        });
        User user = userRepository.saveAndFlush(new User(steamId, userName, password, rank));
        userRepository.save(user);
        return userDtoFactory.createUserDto(user);
    }

    @DeleteMapping(DELETE_USER)
    public void deleteUser(@RequestParam(value = "id") Long steamId) {
        userRepository.findById(steamId).orElseThrow(() -> new NotFoundException(String.format("user not found", steamId)));
        userRepository.deleteById(steamId);
    }


    @GetMapping(GET_USER)
    public UserDto getUser(@RequestParam("id") Long steamId) {
        User user = userRepository.findById(steamId).orElseThrow(() -> new NotFoundException(String.format("user not found", steamId)));
        return userDtoFactory.createUserDto(user);
    }

    @PutMapping(UPDATE_USER)
    public UserDto updateUser(@RequestParam("oldId") Long oldUserId, @RequestBody User newUser) {
        User oldUser = userRepository.findById(oldUserId).orElseThrow(() -> new NotFoundException(String.format("user not found", oldUserId)));
        if (!oldUserId.equals(newUser.getUserId())) {
            userRepository.findById(newUser.getUserId()).ifPresent(user -> {
                throw new AlreadyExistException(String.format("user already exist", newUser.getUserId()));
            });
        }
        if (!oldUser.getUserName().equals(newUser.getUserName())) {
            userRepository.findByUserName(newUser.getUserName()).ifPresent(user -> {
                throw new AlreadyExistException(String.format("user already exist", newUser.getUserName()));
            });
        }
            userRepository.delete(oldUser);
            userRepository.saveAndFlush(newUser);
            return userDtoFactory.createUserDto(newUser);
    }


}
