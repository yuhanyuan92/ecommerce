package com.ecommerce.shops.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * @program: qlm-zxhy
 * @description: 全局事务
 * @author: hanyuan.yu
 * @create: 2019/1/29 14:01
 * @Version 1.0
 **/
@Aspect
@Configuration
public class TransactionAdviceConfig {
    private static final String AOP_POINTCUT_EXPRESSION = "execution(* com.ecommerce.shops.service.impl.*.*(..))";

    @Autowired
    PlatformTransactionManager transactionManager;

    @Bean
    public TransactionInterceptor txAdvice() {
        DefaultTransactionAttribute ATTR_REQUIRED = new DefaultTransactionAttribute();
        ATTR_REQUIRED.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        DefaultTransactionAttribute ATTR_REQUIRED_READONLY = new DefaultTransactionAttribute();
        ATTR_REQUIRED_READONLY.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        ATTR_REQUIRED_READONLY.setReadOnly(true);
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        source.addTransactionalMethod("add*", ATTR_REQUIRED);
        source.addTransactionalMethod("save*", ATTR_REQUIRED);
        source.addTransactionalMethod("insert*", ATTR_REQUIRED);
        source.addTransactionalMethod("update*", ATTR_REQUIRED);
        source.addTransactionalMethod("delete*", ATTR_REQUIRED);
        source.addTransactionalMethod("select*", ATTR_REQUIRED_READONLY);
        source.addTransactionalMethod("list*", ATTR_REQUIRED_READONLY);
        source.addTransactionalMethod("find*", ATTR_REQUIRED_READONLY);
        source.addTransactionalMethod("count*", ATTR_REQUIRED_READONLY);
        return new TransactionInterceptor(transactionManager, source);
    }

    @Bean
    public Advisor txAdviceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }
}