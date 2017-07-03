package com.littlersmall.enums;

/**
 * Created by littlersmall on 2017/6/27.
 */
public enum LogLevel {
    DEBUG(1, "debug"),
    INFO(2, "info"),
    WARN(3, "warn"),
    ERROR(5, "error");

    int id;
    String desc;

    LogLevel(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }
}
