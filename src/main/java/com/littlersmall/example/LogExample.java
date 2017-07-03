package com.littlersmall.example;

import org.springframework.stereotype.Service;

import com.littlersmall.annotation.Log;
import com.littlersmall.enums.LogLevel;

/**
 * Created by littlersmall on 2017/6/27.
 */
@Service
public class LogExample {
    @Log
    public int argTest(String param1, String param2) {
        return 1;
    }

    @Log(level = LogLevel.WARN)
    public void timeTest() throws InterruptedException {
        Thread.sleep(1000);
    }
}
