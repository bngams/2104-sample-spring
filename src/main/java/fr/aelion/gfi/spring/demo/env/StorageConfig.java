package fr.aelion.gfi.spring.demo.env;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

// @Component
@Configuration
@ConfigurationProperties(prefix="app.storage")
@Data
@Log
public class StorageConfig {
    private String local;
    private String aws;

    @PostConstruct
    private void log() {
        log.info("Storage initialized with local: " + this.local);
    }
}
