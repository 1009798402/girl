package com.man.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述:
 *
 * @author C
 * Date: 2018-07-09
 * Time: 22:47
 */
@Aspect
@Component
public class GirlAspect {

    private static final Logger logger = LoggerFactory.getLogger(GirlAspect.class);

    @Pointcut("execution(public * com.man.girl.controller.GirlController.*(..))")
    public void log(){}

    /**
     * 获得请求的信息打印日志
     * @param joinPoint
     */
    @Before("log()")
    public void before(JoinPoint joinPoint){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url = {}",request.getRequestURL());

        //method
        logger.info("method = {}",request.getMethod());

        //ip
        logger.info("ip = {}",request.getRemoteAddr());

        //类名
        String typeName = joinPoint.getSignature().getDeclaringTypeName();
        //类方法
        logger.info("class_method = {}",typeName + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args = {}",joinPoint.getArgs());

    }

    @After("log()")
    public void after(){

        System.out.println("之后的方法");
    }


    /**
     * 获得返回的信息打印日志
     */
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response = {}",object);
    }


}
