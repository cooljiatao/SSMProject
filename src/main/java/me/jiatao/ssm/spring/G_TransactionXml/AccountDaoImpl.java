package me.jiatao.ssm.spring.G_TransactionXml;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

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