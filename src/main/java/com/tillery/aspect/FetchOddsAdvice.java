package com.tillery.aspect;

import com.tillery.model.Odds;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FetchOddsAdvice {

    @Around("com.tillery.aspect.OddsPointcuts.oddsFetchPointcut(mock)")
    public Object fetchOddsMockPointcut(ProceedingJoinPoint pjp, String mock) throws Throwable {
        if (StringUtils.equalsIgnoreCase(mock, "true")) {
            return Odds.builder()
                    .competitorA(Odds.Competitor.builder().name("Mock Team A").odds("-120").build())
                    .competitorB(Odds.Competitor.builder().name("Mock Team B").odds("+115").build())
                    .build();
        }
        return pjp.proceed();
    }

}
