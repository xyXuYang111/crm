package com.xuyang.crm.aspectjrt;

import com.xuyang.crm.redis.RedisService;
import com.xuyang.crm.redis.redisRepository.RedisRepository;
import com.xuyang.crm.util.DateUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;

/**
 * 接口访问监听
 * 监听前端接口的所有访问：收集日志
 */
@Data
@Slf4j
@Component
@Aspect
public class LogAspectJrt {

    @Autowired
    private RedisService redisService;

    public void setRedisService(RedisService redisService) {
        this.redisService = redisService;
    }
//指定切入点表达式，拦截那些方法，即为那些类生成代理对象
    //@Pointcut("execution(* com.bie.aop.UserDao.save(..))")  ..代表所有参数
    //@Pointcut("execution(* com.bie.aop.UserDao.*())")  指定所有的方法
    //@Pointcut("execution(* com.bie.aop.UserDao.save())") 指定save方法

    @Pointcut("execution(* com.xuyang.crm.controller.*.*(..))")
    public void pointCut(){ }

    /**
     * 参数校验
     * @param joinPoint
     */
    @Before("pointCut()")
    public void begin(JoinPoint joinPoint){
        log.info("前置通知");
        log.info("目标方法名为:" + joinPoint.getSignature().getName());
        log.info("目标方法所属类的简单类名:" + joinPoint.getSignature().getDeclaringType().getSimpleName());
        log.info("目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());

        //获取传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("第" + (i+1) + "个参数为:" + args[i]);
        }
        log.info("被代理的对象:" + joinPoint.getTarget());
        log.info("代理对象自己:" + joinPoint.getThis());


    }

    /**
     * 异常抓取
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        log.info("环绕异常通知");
        String methodName = joinPoint.getSignature().getName();
        log.info("执行的方法名：" + methodName);
        StringBuilder stringBuilder = new StringBuilder();
        value(joinPoint, stringBuilder);
        String date = DateUtil.getNowTime();
        String key = String.valueOf(System.currentTimeMillis());

        //操作内容记录
        RedisRepository.setMap(date, methodName, stringBuilder.toString());
        //消息异常机制：日志记录
        RedisRepository.setMap(date, key, e.getMessage());
    }

    /**
     * 操作成功日志记录
     *
     * @param joinPoint
     */
    @After("pointCut()")
    public void close(JoinPoint joinPoint) {
        log.info("后置通知");

        String methodName = joinPoint.getSignature().getName();
        log.info("执行的方法名：" + methodName);

        StringBuilder stringBuilder = new StringBuilder();
        value(joinPoint, stringBuilder);
        String date = DateUtil.getNowTime();
        String key = String.valueOf(System.currentTimeMillis());

        //操作内容记录
        RedisRepository.setMap(date, methodName, stringBuilder.toString());
        //消息异常机制：日志记录
        RedisRepository.setMap(date, key, "操作成功");
    }

    private void value(JoinPoint joinPoint, StringBuilder stringBuilder){
        //获取传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            log.info("第" + (i + 1) + "个参数为:" + args[i]);
            stringBuilder.append(args[i]).append(",");
        }
    }
}
