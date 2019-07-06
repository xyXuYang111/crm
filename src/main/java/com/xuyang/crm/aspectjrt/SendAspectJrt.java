package com.xuyang.crm.aspectjrt;

import com.xuyang.crm.model.Error;
import com.xuyang.crm.redis.RedisMessageListener;
import com.xuyang.crm.redis.RedisService;
import com.xuyang.crm.redis.redisRepository.RedisRepository;
import com.xuyang.crm.util.DateUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 接口访问监听
 * 监听前端接口的所有访问：收集日志
 */
@Data
@Slf4j
@Component
@Aspect
public class SendAspectJrt {

    @Autowired
    private RedisMessageListener redisMessageListener;

    public void setRedisMessageListener(RedisMessageListener redisMessageListener) {
        this.redisMessageListener = redisMessageListener;
    }
//指定切入点表达式，拦截那些方法，即为那些类生成代理对象
    //@Pointcut("execution(* com.bie.aop.UserDao.save(..))")  ..代表所有参数
    //@Pointcut("execution(* com.bie.aop.UserDao.*())")  指定所有的方法
    //@Pointcut("execution(* com.bie.aop.UserDao.save())") 指定save方法

    @Pointcut("execution(* com.xuyang.crm.*.*.*(..))")
    public void pointCut(){ }

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
        String date = DateUtil.getNowSecond();

        Error error = new Error();
        error.setMethodName(methodName);
        error.setMsg(e.getMessage());
        error.setParam(stringBuilder.toString());
        error.setDate(date);
        redisMessageListener.sendMessage("chart_error", error);
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
