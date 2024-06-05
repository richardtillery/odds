package com.tillery.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class OddsPointcuts {

    @Pointcut("execution(* com.tillery.resource.OddsController.fetchOddsForTeams(..)) && args(..,mock)")
    public void oddsFetchPointcut(String mock) {}

}
