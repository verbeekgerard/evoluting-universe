package eu.luminis.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Population", description = "Endpoint for information and management of the population")
public class PopulationController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());


}
