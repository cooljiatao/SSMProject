package me.jiatao.ssm.spring.G_TransactionXml;

public class AccountServiceImpl implements IAccountService{

    //注入dao
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }


    //转账操作的业务逻辑
    public void transfer(String outName,String inName,Double money){
        //调用dao层
        //先取出
        accountDao.out(outName, money);

//        int x=1/0;
        //再转入
        accountDao.in(inName, money);
    }

}