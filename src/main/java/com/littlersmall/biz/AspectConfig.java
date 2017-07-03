package com.littlersmall.biz;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by littlersmall on 2017/5/17.
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Configuration
//开启aspectJ
public class AspectConfig {
}
