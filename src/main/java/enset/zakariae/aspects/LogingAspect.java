package enset.zakariae.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Aspect
public class LogingAspect {

    Logger logger = Logger.getLogger(LogingAspect.class.getName());
    long t1,t2;

    public LogingAspect() throws Exception {
        logger.addHandler(new FileHandler("log.xml"));
        logger.setUseParentHandlers(false);
    }
    @Pointcut("execution(* enset.zakariae.metier.IMetierImpl.*(..))")
    public void pc1(){}

  /* @Before("pc1()")
    public void logBefore(JoinPoint jp){
        t1=System.currentTimeMillis();
        logger.info("***********************************");
        logger.info("Avant l'exécution de la méthode"+jp.getSignature().getName());
    }

    @After("pc1()")
    public void logAfter(JoinPoint jp){
        logger.info("Après l'exécution de la méthode"+jp.getSignature().getName());
        t2=System.currentTimeMillis();
        logger.info("Durée d'exécution de la méthode "+jp.getSignature().getName()+" est "+(t2-t1)+" ms");
        logger.info("-----------------------------------");
    }
*/
    @Around("pc1()")
        public Object logArround(ProceedingJoinPoint jp,JoinPoint joinPoint) throws Throwable {
        t1=System.currentTimeMillis();
        logger.info("***********************************");
        logger.info("Avant l'exécution de la méthode"+joinPoint.getSignature());
        Object result = jp.proceed();
        logger.info("Après l'exécution de la méthode"+joinPoint.getSignature());
        t2=System.currentTimeMillis();
        logger.info("Durée d'exécution de la méthode "+joinPoint.getSignature()+" est "+(t2-t1)+" ms");
        logger.info("-----------------------------------");
        return result;
    }
}
