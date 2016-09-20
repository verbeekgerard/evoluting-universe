package eu.luminis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String swagger() {
        return "redirect:swagger-ui.html";
    }
    
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String swagger() {
        return "redirect:swagger-ui.html";
    }
}
