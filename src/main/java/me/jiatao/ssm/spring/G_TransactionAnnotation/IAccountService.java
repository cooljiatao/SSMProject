package me.jiatao.ssm.spring.G_TransactionAnnotation;

public interface IAccountService {
    void transfer(String outName, String inName, Double money);
}
