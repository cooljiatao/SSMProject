package me.jiatao.ssm.spring.G_TransactionAnnotation;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

    /**
     *      第一步：创建表t_account
     *      CREATE TABLE `t_account` (
     *        `id` INT(11) NOT NULL AUTO_INCREMENT,
     *        `name` VARCHAR(20) NOT NULL,
     *        `money` DOUBLE DEFAULT NULL,
     *        PRIMARY KEY (`id`)
     *      ) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
     *
     *      第二步：插入测试数据：
     *      INSERT INTO `t_account` VALUES (1, 'Tom', 1000);
     *      INSERT INTO `t_account` VALUES (2, 'Jack', 1100);
     *      INSERT INTO `t_account` VALUES (3, 'Rose', 1200);
     */


    //注入数据源
    ////@Autowired
    //private DataSource dataSource;//没有注入数据源成功~
    ////原理：放到属性上的的注解相当于，自动生成setter方法上加注解
    //@Autowired	//自动到spring的容器中寻找类型是参数类型（DataSource）的bean
    //public void setDataSource(DataSource dataSource){
    //	this.dataSource=dataSource;
    //}

    @Autowired//当初始化dao的时候，会调用该方法啊，通过set方法的形参注入数据源
    //方法名无所谓
    public void setSuperDataSource(DataSource dataSource){
        //调用父类的方法
        super.setDataSource(dataSource);
    }


    //（存入）转入
    public void in(String name,Double money){
        String sql="update t_account set money = money+ ? where name = ?";
        super.getJdbcTemplate().update(sql, money,name);
    }

    //（取出）转出
    public void out(String name,Double money){
        String sql="update t_account set money = money- ? where name = ?";
        super.getJdbcTemplate().update(sql, money,name);
    }
}