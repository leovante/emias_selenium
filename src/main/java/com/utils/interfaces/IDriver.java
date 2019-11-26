package com.utils.interfaces;

import com.utils.HighlightSettings;

public interface IDriver<T> {
    String registerDriver(String driverName);

    void setRunType(String runType);
    void setRemoteHubUrl(String url);

    T getDriver();

    boolean hasDrivers();

    boolean hasRunDrivers();

    String currentDriverName();
    void setCurrentDriver(String driverName);

    T getDriver(String name);

    void highlight(IElement element);

    void highlight(IElement element, HighlightSettings highlightSettings);

    String getDriverPath();

    void setDriverPath(String driverPath);

}
