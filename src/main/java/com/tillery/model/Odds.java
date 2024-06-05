package com.tillery.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Odds {
    private Competitor competitorA;
    private Competitor competitorB;

    @Data
    @Builder
    public static class Competitor {
        private String name;
        private String odds;
    }
}
