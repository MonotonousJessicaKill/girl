package jielin.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);
    @Before("execution(public * jielin.girl.controller.GIrlController.*(..))")
    public void logBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        logger.info("url={}",request.getRequestURI());
        logger.info("method={}",request.getMethod());
        logger.info("ip={}",request.getRequestURL());
        logger.info("ClassMethod={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("execution(public * jielin.girl.controller.GIrlController.*(..))")
    public void logAfter(){
        System.out.println("after1");
        logger.info("处理完毕");
    }
    @AfterReturning(returning = "object", pointcut = "execution(public * jielin.girl.controller.GIrlController.*(..))")
    public void afterReturn(Object object){
        logger.info("response={}",object);
    }

    // 以下代码和上述代码能产生一样的效果，并且优先执行
    @Pointcut("execution(public * jielin.girl.controller.GIrlController.*(..))")
    public void generalLog(){

    }
    @Before("generalLog()")
    public void beforeLog(){
        System.out.println("before2");
    }
    @Before("generalLog()")
    public void afterLog(){
        System.out.println("after2");
    }
}
