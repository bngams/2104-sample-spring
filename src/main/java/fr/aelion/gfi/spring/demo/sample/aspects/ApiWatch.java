package fr.aelion.gfi.spring.demo.sample.aspects;

import lombok.extern.java.Log;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log
public class ApiWatch {

    @After("execution(public * fr.aelion.gfi.spring.demo.sample.controllers.api.*.*(..))")
    public void countApiCall() {
        log.info("API Watch: a call has been made on API");
    }
}
