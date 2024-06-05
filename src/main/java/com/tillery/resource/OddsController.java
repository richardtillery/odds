package com.tillery.resource;

import com.tillery.model.Odds;
import com.tillery.model.OddsRecord;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("odds")
public class OddsController {

    @PostMapping(path="/fetchOdds", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public Odds fetchOddsForTeams(@RequestBody OddsRequest oddsRequest, @RequestHeader("mock") String mock) {

        return Odds.builder()
                .competitorA(Odds.Competitor.builder().name(oddsRequest.getTeamA()).odds("-120").build())
                .competitorB(Odds.Competitor.builder().name(oddsRequest.getTeamB()).odds("+115").build())
                .build();
    }

    @PostMapping(path="fetchOddsV2", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public OddsRecord fetchOddsForTeamsV2(@RequestBody OddsRequest oddsRequest) {
        return new OddsRecord(new OddsRecord.CompetitorRecord(oddsRequest.getTeamA(), "-120"),
                new OddsRecord.CompetitorRecord(oddsRequest.getTeamB(), "+120"));
    }
}

@Data
class OddsRequest {
    private String teamA;
    private String teamB;
}

