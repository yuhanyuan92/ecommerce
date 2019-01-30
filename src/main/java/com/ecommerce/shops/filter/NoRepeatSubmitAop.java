package com.ecommerce.shops.filter;

import com.alibaba.fastjson.JSON;
import com.ecommerce.shops.bean.resp.ErrorCode;
import com.ecommerce.shops.bean.resp.Result;
import com.google.common.cache.Cache;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: qlm-zxhy
 * @description: aop解析注解
 * @author: hanyuan.yu
 * @create: 2019/1/30 14:06
 * @Version 1.0
 **/
@Aspect
@Component
public class NoRepeatSubmitAop {
    private Log logger = LogFactory.getLog(getClass());

    @Autowired
    private Cache<String, Integer> cache;

    @Around("execution(* com.ecommerce.shops.controller.*.*(..)) && @annotation(nrs)")
    public Object arround(ProceedingJoinPoint pjp, NoRepeatSubmit nrs) {
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            String sessionId = RequestContextHolder.getRequestAttributes().getSessionId();
            HttpServletRequest request = attributes.getRequest();
            String key = sessionId + "-" + request.getServletPath();
            if (cache.getIfPresent(key) == null) {// 如果缓存中有这个url视为重复提交
                Object o = pjp.proceed();
                cache.put(key, 0);
                return o;
            } else {
                logger.error("重复提交");
                return null;
            }
        } catch (Throwable e) {
            Result result = new Result(ErrorCode.Error.getCode(), "验证重复提交时出现未知异常!");
            e.printStackTrace();
            logger.error("验证重复提交时出现未知异常!");
            return JSON.toJSONString(result, true);
        }
    }

}