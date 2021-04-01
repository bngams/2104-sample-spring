package fr.aelion.gfi.spring.demo.sample.services;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service("MyServiceBis")
@Log
public class DemoServiceBis implements IDemoService {
    @Override
    public Integer getSomeValue() {
        return 10;
    }
}
