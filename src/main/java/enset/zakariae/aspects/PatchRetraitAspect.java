package enset.zakariae.aspects;

import enset.zakariae.metier.IMetierImpl;
import enset.zakariae.metier.compte;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PatchRetraitAspect {
    @Pointcut("execution(* enset.zakariae.metier.IMetierImpl.retirer(..))")
    public void pc1(){}
    @Around("pc1() && args(code,montant)")
    public Object autourRetirer(Long code , double montant, ProceedingJoinPoint jp, JoinPoint joinPoint) throws Throwable {
        IMetierImpl metier = (IMetierImpl) jp.getTarget();
        compte c = metier.consulter(code);
        if(c.getSolde()<montant) throw new RuntimeException("Solde insuffisant");
        return jp.proceed();
    }
}
