package com.logger;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class STLogger implements ILogger{
    private Logger logger;

    public STLogger(){
        this("ST Logger");
    }

    public STLogger(String name){
        logger = getLogger(name);
    }

    @Override
    public void step(String msg) {

    }

    @Override
    public void setLogLevel(LogLevels levels) {

    }
//    public STLogger(String name){
//        logger = gerLogger(name);
//        this.name = name;
//    }
}
