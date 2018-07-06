package me.jiatao.ssm.spring.E_AspectJAnnotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * @Component(“myAspect”)：将增强的类交给spring管理，才可以增强
 * @Aspect：将该类标识为切面类（这里面有方法进行增强），相当于<aop:aspect ref=”myAspect”>
 **/

@Component("aspectJAnnotation")
@Aspect
public class AspectJAnnotation {
    /**
     * @AspectJ提供不同的通知类型
     *
     * @Before 前置通知，相当于BeforeAdvice
     * @AfterReturning 后置通知，相当于AfterReturningAdvice
     * @Around 环绕通知，相当于MethodInterceptor
     * @AfterThrowing抛出通知，相当于ThrowAdvice
     * @After 最终final通知，不管是否异常，该通知都会执行
     * @DeclareParents 引介通知，相当于IntroductionInterceptor (不要求掌握)
     */


    //region  配置切点的两种方式

    /**
     * 前置通知
     * 相当于：<aop:before method="before" pointcut="bean(*Service)"/>
     *
     * @param joinPoint
     * @Before("bean(*Service)")：参数值：自动支持切入点表达式或切入点名字
     */
//    @Before("bean(*Service)")
//    public void before(JoinPoint joinPoint) {
//        System.out.println("****** before1 ******");
//    }

    /**
     * 自定义切入点
     * 方法名就是切入点的名字
     * 相当于<aop:pointcut expression="bean(*Service)" id="myPointcut"/>
     */
    @Pointcut("bean(*Service)")
    private void myPointcut() {
    }

    @Pointcut("bean(*Service)")
    private void myPointcut2() {
    }

    /**
     * 前置通知
     * 相当于：<aop:before method="before" pointcut-ref="myPointcut"/>
     * 相当于：<aop:before method="before" pointcut-ref="myPointcut2"/>
     *
     * @param joinPoint
     */
//    @Before("myPointcut()||myPointcut2()")
//    public void before2(JoinPoint joinPoint) {
//        System.out.println("****** before2 ******");
//    }

    //endregion

    /**
     * 后置通知
     * target：拦截某一个类型的bean（唯一），
     * 表示只对CustomerServiceImpl类中的方法做后置通知的查找
     * @param joinPoint
     * @param returnVal
     */
//    @AfterReturning(value="target(me.jiatao.ssm.spring.E_AspectJAnnotation.ICustomerService)",returning="returnVal")
//    public void afterReturning(JoinPoint joinPoint,Object returnVal){
//        System.out.println("=======后置通知=======");
//    }

    /**
     *环绕通知：
     *
     * @Around("execution(*  me.jiatao.ssm.spring.E_AspectJAnnotation.*.*(..))")
     * 要增强返回类型任意，所有的 me.jiatao.ssm.spring.E_AspectJAnnotation包中的类，类中所有的方法，参数任意
     *
     * @Around("execution(* me.jiatao.ssm.spring..*.*(..))")
     * 要增强返回类型任意，me.jiatao.ssm.spring包，及其子包中所有类，类中所有的方法，参数任意
     *
     * @Around("execution(* me.jiatao.ssm..*.save(..))")
     * 要增强me.jiatao.ssm包及其子包中所有的类，类中以save结尾的方法，参数任意
     *
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     *
     * 要增强 me.jiatao.ssm.spring.E_AspectJAnnotation包中的ICustomerService类的子类型的所有方法，参数任意
     */
//    @Around("execution(* me.jiatao.ssm..*.save(..))")
//    @Around("execution(* me.jiatao.ssm.spring..*.*(..))")
//    @Around("execution(*  me.jiatao.ssm.spring.E_AspectJAnnotation.*.*(..))")
    @Around("execution(* me.jiatao.ssm.spring.E_AspectJAnnotation.ICustomerService +.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("---环绕通知-----前");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("---环绕通知-----后");
        return object;
    }

    /**
     * 抛出通知
     * 切入点表达式：增强所有me包以及子包下面的所有类型的bean的所有方法
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value="within(me..*)",throwing="ex")
    public void afterThrowing(JoinPoint joinPoint ,Throwable ex){
        System.out.println("---抛出通知。。。。。。"+"抛出的异常信息："+ex.getMessage());
    }

    /**
     * 最终通知
     * 拦截所有以ice结尾的bean
     * @param joinPoint
     */
    @After("bean(*Service)")
    public void after(JoinPoint joinPoint){
        System.out.println("+++++++++最终通知。。。。。。。");
    }


}
