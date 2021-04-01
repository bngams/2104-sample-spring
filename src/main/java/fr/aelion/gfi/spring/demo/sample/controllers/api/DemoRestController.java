package fr.aelion.gfi.spring.demo.sample.controllers.api;

import fr.aelion.gfi.spring.demo.env.StorageConfig;
import fr.aelion.gfi.spring.demo.sample.services.DemoService;
import fr.aelion.gfi.spring.demo.sample.services.IDemoService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @Component <--> @Bean
// @Controller extends @Component
// @Controller
// @Controller + @ResponseBody()
@RestController
@Log
public class DemoRestController {

    private IDemoService ds;

    @Autowired
    public DemoRestController(@Qualifier("MyServiceBis") IDemoService ds) {
        this.ds = ds;
    }

    // HTTP verb = GET
    // @RequestMapping(value = "/hello", method = RequestMethod.GET)
    // @RequestMapping("/hello")
    @GetMapping("/api/hello/{name}")
    public String index(@PathVariable(required = true) String name) {
        log.info("call /api/hello with value " + this.ds.getSomeValue());
        return "Hello " + name + "!";
    }

}
