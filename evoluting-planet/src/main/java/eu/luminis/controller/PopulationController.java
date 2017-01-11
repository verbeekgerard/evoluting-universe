package eu.luminis.controller;

import eu.luminis.export.PopulationExporter;
import io.swagger.annotations.Api;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

@RestController
@Api(value = "Population", description = "Endpoint for information and management of the population")
public class PopulationController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/getPopulation", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody void getPopulation(HttpServletResponse response) throws IOException {
        File jsonFile = getFile();
        startDownload(response, jsonFile);
        log.info("Population downloaded");
    }

    private File getFile() throws IOException {
        String jsonString = PopulationExporter.export();
        File jsonFile = File.createTempFile("population", ".json");
        FileUtils.writeStringToFile(jsonFile, jsonString, Charset.defaultCharset());
        return jsonFile;
    }

    private void startDownload(HttpServletResponse response, File jsonFile) {
        String planetName = System.getProperty("spring.application.name");

        try(InputStream in = new FileInputStream(jsonFile)) {

            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename=" + planetName + ".json");
            response.setHeader("Content-Length", String.valueOf(jsonFile.length()));

            FileCopyUtils.copy(in, response.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}