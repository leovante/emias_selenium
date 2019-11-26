package com.utils.logger;

public enum LogLevels {
    OFF(-1),        // No logging
    FATAL(0),       // Unexpected errors
    ERROR(3),       // Critical errors
    WARNING(4),     // Errors due to wrong params
    STEP(5),        // BDD logging style
    INFO(6),        // Actions Info
    DEBUG(7),       // Debug info (not for prod)
    TRACE(8),       // Trace info (not for prod)
    ALL(100);       // All log messages

    private int priority;

    LogLevels(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public boolean equalOrLessThan(LogLevels level) {
        return getPriority() >= level.getPriority();
    }

}
