package fr.aelion.gfi.spring.demo.sample.services;

import lombok.Data;
import lombok.Getter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Random;

// @Service <--> @Component
// @Scope("singleton")
// @Scope("prototype")
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Log
@Getter
public class DemoService implements IDemoService {

    private Integer someValue;

    @PostConstruct
    private void log() {
        this.someValue = new Random().nextInt(100);
        log.info("DemoService created with value " + this.someValue);
    }
}
