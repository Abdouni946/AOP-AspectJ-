package enset.zakariae.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class FirstAspect {
      //  @Pointcut("execution(* enset.zakariae.test.*.main(..))")
        public void pc1() { }

     //   @Before("pc1()")
        public void beforeMain() {
                System.out.println("**********");
                System.out.println("Before main from Aspect with Class syntax");
                System.out.println("**********");
        }

      //  @After("pc1()")
        public void AfterMain() {
            System.out.println("**********");
            System.out.println("After main from Aspect with Class syntax");
            System.out.println("**********");
        }


    //    @Around("pc1()") // remplace Before et After
            public void AroundMain(ProceedingJoinPoint pjp) throws Throwable {
                System.out.println("**********");
                System.out.println("Around main from Aspect with Class syntax");
                System.out.println("**********");
                pjp.proceed();
                System.out.println("**********");
                System.out.println("Around main from Aspect with Class syntax");
                System.out.println("**********");
            }

}