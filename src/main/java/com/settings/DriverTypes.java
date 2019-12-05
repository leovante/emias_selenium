package com.settings;

public enum DriverTypes {
    CHROME("chrome"),
    FIREFOX("firefox"),
    IE("ie"),
    EDGE("edge"),
    PHANTOMJS("phantom"),
    OPERA("opera");

    public final String name;

    DriverTypes(String name) {
        this.name = name;
    }
}