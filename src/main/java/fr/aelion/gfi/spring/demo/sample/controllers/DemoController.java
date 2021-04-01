package fr.aelion.gfi.spring.demo.sample.controllers;

import fr.aelion.gfi.spring.demo.sample.services.DemoService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log
public class DemoController {

    private DemoService ds;

    @Autowired
    public DemoController(DemoService ds) {
        this.ds = ds;
    }

    // /hello?name=...
    @GetMapping("/hello")
    public String index(@RequestParam(name="name") String name, Model model) {
        log.info("call /hello with value " + this.ds.getSomeValue());
        model.addAttribute("name", name);
        return "index";
    }
}
