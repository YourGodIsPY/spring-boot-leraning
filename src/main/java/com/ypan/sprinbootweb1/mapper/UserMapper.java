package com.ypan.sprinbootweb1.mapper;

import com.ypan.sprinbootweb1.entities.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> selectAllUser();

    User selectUserByNamePwd(User user);

    boolean addUser(User user);

    User selectUserById(Integer userId);

    boolean deleteUser(Integer userId);

    User updateUser(User user);

}
