package com.ypan.sprinbootweb1.service;

import com.ypan.sprinbootweb1.entities.User;

import java.util.List;

public interface IUserService {

    List<User> selectAllUser();

    User selectUserByNamePwd(User user);

    boolean addUser(User user);

    User selectUserById(Integer userId);

    boolean deleteUser(Integer userId);

    User updateUser(User user);


}
