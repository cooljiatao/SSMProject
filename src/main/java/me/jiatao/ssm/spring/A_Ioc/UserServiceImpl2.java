package me.jiatao.ssm.spring.A_Ioc;

public class UserServiceImpl2 implements IUserService {

    private IUserDao userDao2;

    public void setUserDao2(IUserDao userDao2) {
        this.userDao2 = userDao2;
    }

    public void login() {
        System.out.println("UserServiceImpl2-service层被调用了。。。");

        userDao2.findByUsernameAndPassword();

    }
}
