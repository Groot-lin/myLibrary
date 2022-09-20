package cqut.cn.edu.service;

import cqut.cn.edu.mapper.UserMapper;
import cqut.cn.edu.pojo.User;
import cqut.cn.edu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    //登录
    public User login(String username,String password){
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.select(username,password);

        sqlSession.close();
        return user;
    }
    //查看用户名是否存在
    public User usernameIsExist(String username){
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByUsername(username);

        sqlSession.close();
        return user;
    }
    
}
