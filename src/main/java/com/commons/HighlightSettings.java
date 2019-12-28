package com.commons;

public class HighlightSettings {
    private String bgColor = "yellow";
    private String frameColor = "red";
    private int timeoutInSec = 1;

    public HighlightSettings() {
    }

    public HighlightSettings(String bgColor, String frameColor, int timeoutInSec) {
        this.bgColor = bgColor;
        this.frameColor = frameColor;
        this.timeoutInSec = timeoutInSec;
    }

    public String getBgColor() {
        return bgColor;
    }

    public HighlightSettings setBgColor(String bgColor) {
        this.bgColor = bgColor;
        return this;
    }

    public String getFrameColor() {
        return frameColor;
    }

    public HighlightSettings setFrameColor(String frameColor) {
        this.frameColor = frameColor;
        return this;
    }

    public int getTimeoutInSec() {
        return timeoutInSec;
    }

    public HighlightSettings setTimeoutInSec(int timeoutInSec) {
        this.timeoutInSec = timeoutInSec;
        return this;
    }
}
