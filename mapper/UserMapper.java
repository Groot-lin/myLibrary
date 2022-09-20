package cqut.cn.edu.mapper;

import cqut.cn.edu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    //注解完成增删改查
    //根据用户名密码完成查询对象
    @Select("select * from user where username=#{username} and password=#{password}")
    User select(@Param("username") String username, @Param("password") String password);

    //查询用户是否存在
    @Select("select * from user where username = #{username}")
    User selectByUsername(String username);

    //添加用户
    @Insert("insert into user value(null,#{username},#{password})")
    void add(User user);
}
