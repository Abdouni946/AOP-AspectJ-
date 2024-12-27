package enset.zakariae.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Scanner;

@Aspect
public class SecurityAspect {
    @Pointcut("execution(* enset.zakariae.test.Main.start(..))")
    public void startAppPointcut() {}

    @Around("startAppPointcut()")
    public void autourStart(ProceedingJoinPoint jp) throws Throwable {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        if (username.equals("admin") && password.equals("admin")) {
            jp.proceed();
        } else {
            System.out.println("Invalid credentials. Exiting application.");
        }

    }

}
