package com.course.server.aspect;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.PropertyPreFilters;
import com.course.server.util.UuidUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;

@Aspect
@Component
public class LogAspect {
    private final static Logger LOG = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 定义controller统一的切点
     * public *  匹配所有目标类的public方法
     *com.course.*.controller..  包名下面所有Controller下面的.*(..)所有方法
     */
    @Pointcut("execution(public * com.course.*.controller..*Controller.*(..))")
    public  void  controllerPointcut(){}

    /**
     * 前置通知，主要用于打印请求地址，类名，远程地址
     * @param point
     */
    @Before("controllerPointcut()")
    public void doBefore(JoinPoint point){
        // 日志编号,需要早logback定义对应的变量
        MDC.put("UUID", UuidUtil.getShortUuid());
        // 获取reqeust 对象
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        // 获取方法签名对象
        Signature signature = point.getSignature();
        String name = signature.getName();
        // 打印业务操作
        String nameCn = "";
        if (name.contains("list") || name.contains("query")) {
            nameCn = "查询";
        } else if (name.contains("save")) {
            nameCn = "保存";
        } else if (name.contains("delete")) {
            nameCn = "删除";
        } else {
            nameCn = "操作";
        }
        //  使用反射获取业务系统名称
        String businessName = "";
        Class clazz = signature.getDeclaringType();
        try {
            Field field = clazz.getDeclaredField("BUSINESS_NAME");
            if(!StringUtils.isEmpty(field)){
                businessName = (String) field.get(clazz);
            }
        } catch (NoSuchFieldException e) {
            LOG.warn("业务系统名称要填写");
        } catch (IllegalAccessException e) {
            LOG.error("获取业务名称失败",e);
        }

        // 打印请求信息
        LOG.info("------------- 【{}】{}开始 -------------", businessName, nameCn);
        LOG.info("请求地址: {} {}", request.getRequestURL().toString(), request.getMethod());
        LOG.info("类名方法: {}.{}", signature.getDeclaringTypeName(), name);
        LOG.info("远程地址: {}", request.getRemoteAddr());

        //  获取请求的参数
        Object[] args = point.getArgs();
        if(args.length > 0 ){
            Object[] params = new Object[args.length];
            for(int i = 0,l = args.length; i < l;++i){
                if (args[i] instanceof ServletRequest
                        || args[i] instanceof ServletResponse
                        || args[i] instanceof MultipartFile) {
                    continue;
                }
                params[i] = args[i];
            }
            // 排除字段，敏感字段或太长的字段不显示
            String[] excludeProperties = {"shard"};
            PropertyPreFilters filters = new PropertyPreFilters();
            PropertyPreFilters.MySimplePropertyPreFilter propertyPreFilter = filters.addFilter();
            propertyPreFilter.addExcludes(excludeProperties);
            LOG.info("请求参数: {}", JSONObject.toJSONString(params,propertyPreFilter));
        }

    }

    /**
     * 环绕通知
     * 打印请求执行多少时间，返回值
     * @param proceedingJoinPoint
     */
    @Around("controllerPointcut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        // 排除字段，敏感字段或太长的字段不显示
        String[] excludeProperties = {"password", "shard"};
        PropertyPreFilters filters = new PropertyPreFilters();
        PropertyPreFilters.MySimplePropertyPreFilter excludefilter = filters.addFilter();
        excludefilter.addExcludes(excludeProperties);
        LOG.info("返回结果: {}", JSONObject.toJSONString(result, excludefilter));
        LOG.info("------------- 结束 耗时：{} ms -------------", System.currentTimeMillis() - startTime);
        return result;
    }
}
