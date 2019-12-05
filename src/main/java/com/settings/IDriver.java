package com.settings;

public interface IDriver<T> {
    String registerDriver(String driverName);
    void setRemoteHubUrl(String url);
}