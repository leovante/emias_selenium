package com.commons;

import static java.lang.ThreadLocal.withInitial;

public class TimeoutSettings {
    private ThreadLocal<Integer> waitElementSec = withInitial(() -> 20);
    private ThreadLocal<Integer> defaultWaitTimeout = withInitial(() -> 20);
    private ThreadLocal<Integer> waitPageLoadSec = withInitial(() -> 20);
    private ThreadLocal<Integer> retryMSec = withInitial(() -> 100);

    public TimeoutSettings() {
        setCurrentTimeoutSec(waitElementSec.get());
    }

    public void setDefaultTimeoutSec(int timeoutSec) {
        defaultWaitTimeout.set(timeoutSec);
    }

    public void setCurrentTimeoutSec(int timeoutSec) {
        waitElementSec.set(timeoutSec);
    }

    public int getDefaultTimeoutSec() {
        return defaultWaitTimeout.get();
    }

    public int getCurrentTimeoutSec() {
        return waitElementSec.get();
    }

    public void dropTimeouts() {
        setCurrentTimeoutSec(defaultWaitTimeout.get());
    }

}
