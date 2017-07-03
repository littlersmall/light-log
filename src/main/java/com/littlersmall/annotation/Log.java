package com.littlersmall.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.littlersmall.enums.LogLevel;

/**
 * Created by littlersmall on 2015/6/25.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD})
@Inherited
public @interface Log {
    LogLevel level() default LogLevel.INFO;
}
