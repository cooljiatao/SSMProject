package me.jiatao.ssm.mybatis.B_CURD;

import me.jiatao.ssm.mybatis.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements IUserDao{
    private SqlSession sqlSession;

    public UserDaoImpl(){}

    /**
     * 临时书写
     */
    public  UserDaoImpl( SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> queryAllUser() {
        return  sqlSession.selectList("UserDao.queryAllUser");
    }

    @Override
    public User queryUserById(Long id) {
        return sqlSession.selectOne("UserDao.queryUserById", id);
    }

    @Override
    public void saveUser(User user) {
        sqlSession.insert("UserDao.saveUser", user);
    }

    @Override
    public void updateUser(User user) {
        sqlSession.update("UserDao.updateUser", user);
    }

    @Override
    public void deleteUserById(Long id) {
        sqlSession.delete("UserDao.deleteUserById", id);
    }

}
