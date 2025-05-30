package ru.CheSeVe.lutiy_project.factory;

import org.springframework.stereotype.Component;
import ru.CheSeVe.lutiy_project.dto.MatchUserDto;
import ru.CheSeVe.lutiy_project.entity.MatchUser;

@Component
public class MatchUserDtoFactory {
     public MatchUserDto MatchUserDto(MatchUser matchUser) {
         return MatchUserDto.builder()
                 .matchUserId(matchUser.getMatchUserId())
                 .items(matchUser.getItems())
                 .hero(matchUser.getHero())
                 .steamId(matchUser.getSteamId())
                 .hasWon(matchUser.getHasWon())
                 .match(matchUser.getMatch())
                 .user(matchUser.getUser()).build();
     }
}
