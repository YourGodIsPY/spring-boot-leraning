package com.ypan.sprinbootweb1.service;

import com.ypan.sprinbootweb1.entities.User;

import java.util.List;

public interface IUserService {

    List<User> selectAllUser();

    User selectUserByNamePwd(User user);

    User addUser(User user);

    User selectUserById(Integer userId);


}
