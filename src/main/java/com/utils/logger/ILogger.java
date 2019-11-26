package com.utils.logger;

import org.slf4j.Logger;

public interface ILogger extends Logger{
    <T> T logOff(JFuncREx<T> action);
    void logOff(JActionEx action);
    void step(String msg);
    void setLogLevel(LogLevels levels);

}
