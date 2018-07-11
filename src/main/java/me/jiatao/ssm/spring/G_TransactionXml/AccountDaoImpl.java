package me.jiatao.ssm.spring.G_TransactionXml;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

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