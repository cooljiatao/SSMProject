package me.jiatao.ssm.spring.D_AspectJXML;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * aspectj的advice通知增强类，无需实现任何接口
 */
public class AspectXml {

/**
        五种通知小结：
            （1）只要掌握Around（环绕通知）通知类型，就可实现其他四种通知效果。
            （2）因为你可以在环绕通知的方法中编写如下代码：
            try {
                //前置通知
                Object result = proceedingJoinPoint.proceed();
                //后置通知
            }catch(Exception){
                 //抛出通知
            }finally{
                //最终通知
            }
 **/


    /**
     * 前置通知
     * 普通的方法。方法名随便，但也不能太随便，一会要配置
     */
    public void firstbefore() {
        System.out.println("------------firstbefore前置通知执行了。。。");
    }

    public void firstbefore2() {
        System.out.println("------------firstbefore2前置通知执行了。。。");
    }

    /**
     * 前置通知的：方法运行之前增强
     * 应用： 权限控制 （权限不足，抛出异常）、 记录方法调用信息日志
     * 参数：org.aspectj.lang.JoinPoint
     *
     * @param joinPoint 连接点对象（方法的包装对象:方法，参数，目标对象）
     */
    public void before(JoinPoint joinPoint) {
        //分析：抛出异常拦截的
        //当前登录用户
        String loginName = "Rose";
        System.out.println("方法名称：" + joinPoint.getSignature().getName());
        System.out.println("目标对象：" + joinPoint.getTarget().getClass().getName());
        System.out.println("代理对象：" + joinPoint.getThis().getClass().getName());
        //判断当前用户有没有执行方法权限
        if (joinPoint.getSignature().getName().equals("find")) {
            if (!loginName.equals("admin")) {
                //只有超级管理员admin有权限，其他人不能执行某个方法，比如查询方法
                throw new RuntimeException("您没有权限执行方法：" + joinPoint.getSignature().getName() + "，类型为：" + joinPoint.getTarget().getClass().getName());
            }
        }
    }

    /**
     * 应用场景：与业务相关的，如网上营业厅查询余额后，自动下发短信。
     * 后置通知：会在目标方法执行之后调用通知方法增强。
     * 参数1：连接点对象（方法的包装对象:方法，参数，目标对象）
     * 参数2：目标方法执行后的返回值,类型是object，“参数名”随便，但也不能太随便，一会要配置
     *
     * @param joinPoint
     * @param returnVal
     */
    public void afterReturing(JoinPoint joinPoint, Object returnVal) {
        //下发短信:调用运行商的接口，短信猫。。。
        System.out.println("------------后置通知-当前下发短信的方法" + "-尊敬的用户，您调用的方法返回余额为：" + returnVal);


        //同时可以可以在下发后，记录日志：
        String targetName = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("------------日志记录，操作的类型：" + targetName + "，操作的方法：" + methodName);
    }

    /**
     * 应用场景：日志、缓存、权限、性能监控、事务管理
     * 环绕通知：在目标对象方法的执行前+后，可以增强
     * 参数：可以执行的连接点对象ProceedingJoinPoint（方法），
     * 特点是调用proceed()方法可以随时随地执行目标对象的方法（相当于目标对象的方法执行了）
     *
     * @param proceedingJoinPoint
     * @return 原方法返回值
     * @throws Throwable 必须抛出一个Throwable
     */
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //目标：事务的控制：
        //开启事务：
        System.out.println("-----开启了事务。。。。。。。。。");
        //执行了目标对象的方法
        Object resultObject = proceedingJoinPoint.proceed();
        //结束事务
        System.out.println("-----提交了事务。。。。。。。。。");

        //目标对象执行的结果
        //可以修改返回值
        return resultObject;
    }

    /**
     * 作用：目标代码出现异常，通知执行。记录异常日志、通知管理员（短信、邮件）
     * 只有目标对象方法抛出异常，通知才会执行
     *
     * @param joinPoint 静态连接点（方法对象）
     * @param ex        目标方法抛出的异常，参数名随便，但也不能太随便
     */
    public void aterThrowing(JoinPoint joinPoint, Throwable ex) {
        //一旦发生异常，发送邮件或者短信给管理员
        System.out.println("管理员您好：" + joinPoint.getTarget().getClass().getName() + "的方法："
                + joinPoint.getSignature().getName() + "发生了异常，异常为：" + ex.getMessage());
    }

    /**
     * 应用场景：释放资源 （关闭文件、 关闭数据库连接、 网络连接、 释放内存对象 ）
     * 最终通知：不管是否有异常都会执行
     *
     * @param joinPoint
     */
    public void after(JoinPoint joinPoint) {
        //释放数据库连接
        System.out.println(joinPoint.getSignature().getName() + "方法执行完毕,资源已释放");
    }

}
