package com.littlersmall.biz;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

import com.littlersmall.annotation.Log;
import com.littlersmall.enums.LogLevel;

/**
 * Created by littlersmall on 2017/6/25.
 */
//记录日志
//1 参数
//2 返回值
//3 执行时间
@Service
@Aspect
public class LogAspect implements Ordered {
    //优先级最高
    //优先级越高，则前置切面(before)越先执行，后置切面(after)越后执行
    //Around属于前置+后置，因此需要将log的优先级提到最高
    @Override
    public int getOrder() {
        return 0;
    }

    @Pointcut("@annotation(com.littlersmall.annotation.Log)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object doSurround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] objects = proceedingJoinPoint.getArgs();
        long startTime = System.currentTimeMillis();
        Class<?> targetClazz = proceedingJoinPoint.getTarget().getClass();
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Log logAnnotation = methodSignature.getMethod().getAnnotation(Log.class);

        StringBuilder logBuilder = new StringBuilder();
        logBuilder.append(String.format("class:%s, function:%s\n",
                targetClazz.getName(), proceedingJoinPoint.getSignature().getName()));
        logBuilder.append(String.format("in args: %s, ", Arrays.toString(objects)));

        Object result = proceedingJoinPoint.proceed();

        logBuilder.append(String.format("out args: %s\nexecute time: %d", result, System.currentTimeMillis() - startTime));

        writeLog(LogMap.getLogger(targetClazz), logBuilder.toString(), logAnnotation.level());

        return result;
    }

    private void writeLog(Logger logger, String log, LogLevel logLevel) {
        switch (logLevel) {
            case DEBUG:
                logger.debug(log);
                break;
            case INFO:
                logger.info(log);
                break;
            case WARN:
                logger.warn(log);
                break;
            case ERROR:
                logger.error(log);
                break;

            default:
                logger.info(log);
                break;
        }
    }
}
