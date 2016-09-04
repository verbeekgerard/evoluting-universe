package eu.luminis.service;

import eu.luminis.general.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by gerardverbeek on 29/08/16.
 */
@Service
public class RunService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public boolean isRunning = false;

    public void stop(){
        if(isRunning){
            log.info("Stopping planet...");
            System.exit(0);
            log.info("Planet stopped!");
        }
    }

    @Async
    public void run(){
        if(!isRunning){
            String[] args = {"false"};
            isRunning = true;
            Run.main(args);
        }
    }
}
