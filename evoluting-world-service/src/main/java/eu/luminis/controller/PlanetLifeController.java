package eu.luminis.controller;

import eu.luminis.domain.ResponseStatus;
import eu.luminis.service.RunService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Planet Life", description = "Endpoint for controlling the planet")
public class PlanetLifeController {

    @Autowired
    RunService runService;

    @RequestMapping(value = "/startPlanet", method = RequestMethod.POST)
    public @ResponseBody
    ResponseStatus start(){
        runService.run();
        return new ResponseStatus("Planet is started",true);
    }

    @RequestMapping(value = "/stopPlanet", method = RequestMethod.POST)
    public @ResponseBody ResponseStatus stop(){
        runService.stop();
        return new ResponseStatus("Planet is stopped",true);
    }
}