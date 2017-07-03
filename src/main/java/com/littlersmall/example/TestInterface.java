package com.littlersmall.example;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.littlersmall.annotation.Log;

/**
 * Created by littlersmall on 2017/6/18.
 */
@Lazy
@Service
public class TestInterface {
    @Log
    public void fun() {
        System.out.println("test interface");
    }
}
