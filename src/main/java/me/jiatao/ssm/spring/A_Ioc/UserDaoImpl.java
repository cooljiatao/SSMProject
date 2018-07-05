package me.jiatao.ssm.spring.A_Ioc;

public class UserDaoImpl implements IUserDao {
    @Override
    public void findByUsernameAndPassword() {
        System.out.println("UserDaoImpl-dao层被调用了");
    }
}
