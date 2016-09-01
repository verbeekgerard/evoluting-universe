package eu.luminis.service;

import eu.luminis.general.Run;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by gerardverbeek on 29/08/16.
 */
@Service
public class RunService {

    @Async
    public void run(){
        String[] args = {"false"};
        Run.main(args);
    }
}
