package eu.luminis.controller;

import eu.luminis.export.PopulationExporter;
import io.swagger.annotations.Api;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

@RestController
@Api(value = "Population", description = "Endpoint for information and management of the population")
public class PopulationController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/getPopulation",method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody FileSystemResource getPopulation(){
        String jsonString = PopulationExporter.export();

        File jsonFile = null;

        try {
            jsonFile = File.createTempFile("population", ".json");
            FileUtils.writeStringToFile(jsonFile, jsonString, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new FileSystemResource(jsonFile);
    }
}