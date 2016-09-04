package eu.luminis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.*;


/**
 * Created by gerardverbeek on 04/09/16.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PlanetDiscoveryServiceTest {

    @MockBean
    private DiscoveryClient discoveryClient;

    @Autowired
    private PlanetDiscoveryService planetDiscoveryService;


    @Test
    public void getPlanetsNames(){

        List<String> names = Arrays.asList("jupiter", "mars", "uranus");
        given(discoveryClient.getServices()).willReturn(names);
        List<String> namesResult = planetDiscoveryService.getPlanetsNames();
        assertThat(namesResult).contains("jupiter", "mars", "uranus");
    }
}
