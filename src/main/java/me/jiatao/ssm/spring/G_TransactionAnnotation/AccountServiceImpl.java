package me.jiatao.ssm.spring.G_TransactionAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 如果 @Transactional 标注在 Class 上面，
 * 那么将会对这个 Class 里面所有的 public 方法都包装事务方法。
 * 等同于该类的每个公有方法都放上了@Transactional。
 * 如果某方法需要单独的事务定义，则需要在方法上加@Transactional来覆盖类上的标注声明。
 * 记住：方法级别的事务覆盖类级别的事务
 */

@Service("accountService")
@Transactional(noRollbackFor =ArithmeticException.class )
public class AccountServiceImpl implements IAccountService {

    //注入dao
    @Autowired
    private IAccountDao accountDao;

    //转账操作的业务逻辑
//	@Transactional//在方法上添加事务
    public void transfer(String outName,String inName,Double money){

        //调用dao层
        //先取出
        accountDao.out(outName, money);
        int d = 1/0;
        //再转入
        accountDao.in(inName, money);
    }

    @Transactional(readOnly=true)//使用局部覆盖全局的
    public void findAccount(){
        System.out.println("查询帐号的信息了");
    }

}