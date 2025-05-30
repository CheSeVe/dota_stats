package ru.CheSeVe.lutiy_project.factory;

import org.springframework.stereotype.Component;
import ru.CheSeVe.lutiy_project.dto.MatchDto;
import ru.CheSeVe.lutiy_project.entity.Match;


@Component
public class MatchDtoFactory {
    public MatchDto createMatchDto(Match match) {
        return MatchDto.builder()
                .matchId(match.getMatchId())
                .matchUsers(match.getMatchUsers()).build();
    }
}
