package fr.aelion.gfi.spring.demo.env;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@Configuration
@Log
public class DemoConfig {

    // SpEL
    // @Value("${dummy.value}") => prefer in constructor for testing
    private String dummyValueFromConf;

    // @Autowired <--> @Inject de Spring
    // @Autowired
    private Environment env;

    //
    public DemoConfig(
            @Value("${dummy.value}") String dummyValueFromConf,
            @Autowired Environment env) {
        this.dummyValueFromConf = dummyValueFromConf;
        this.env = env;
    }

    @PostConstruct()
    private void log() {
        log.info("Env conf loaded, with storage.local: " + this.env.getProperty("app.storage.local"));
    }
}
