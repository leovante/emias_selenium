package com.commons;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.lang.System.currentTimeMillis;

public class Timer {
    private Long start = currentTimeMillis();
    private long timeoutInMSec = 5 * 1000L;
    private long retryTimeoutInMSec = 100;

    public Timer() {
    }

    public Timer(long timeoutInMSec, long retryTimeoutInMSec) {
        this();
        this.timeoutInMSec = timeoutInMSec;
        this.retryTimeoutInMSec = retryTimeoutInMSec;
    }

    public Timer(long timeoutInMSec) {
        this();
        this.timeoutInMSec = timeoutInMSec;
    }

    public Long timePassedInMSec() {
        Long now = currentTimeMillis();
        return now - start;
    }
}
