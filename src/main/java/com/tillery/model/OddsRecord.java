package com.tillery.model;

public record OddsRecord(CompetitorRecord competitorA, CompetitorRecord competitorB) {
    public record CompetitorRecord(String name, String odds) {};
}
