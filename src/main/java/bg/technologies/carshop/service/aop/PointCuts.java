package bg.technologies.carshop.service.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {

    @Pointcut("execution(* bg.technologies.carshop.service.OfferService.getAllOffers(..))")
    public void trackOfferSearch() {

    }

    @Pointcut("@annotation(WarnIfExecutionExceeds)") //Матчни висчки методи, които са анотирани с тази анотация
    public void warnIfExecutionExceeds(){}
}
