package com.ecommerce.shops.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: qlm-zxhy
 * @description: druid连接池监控
 * @author: hanyuan.yu
 * @create: 2019/1/10 14:17
 * @Version 1.0
 **/

@Configuration
public class DruidConfig {
    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");
        //配置用户名
        reg.addInitParameter("loginUsername", "admin");
        //配置密码
        reg.addInitParameter("loginPassword", "123456");
        //在日志中打印执行慢的sql语句
        reg.addInitParameter("logSlowSql", "true");
        //IP白名单 (没有配置或者为空，则允许所有访问)
        //reg.addInitParameter("allow", "192.168.16.110,127.0.0.1");
        //IP黑名单 (存在共同时，deny优先于allow)
        //reg.addInitParameter("deny", "192.168.16.111");
        return reg;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        //过滤文件类型
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        //监控单个url调用的sql列表
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        return filterRegistrationBean;
    }

}