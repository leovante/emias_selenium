package com.logger;

import org.slf4j.Logger;

public interface ILogger  {
    void step(String msg);
    void setLogLevel(LogLevels levels);

}