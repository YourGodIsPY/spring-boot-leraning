package com.ypan.sprinbootweb1.service.impl;

import com.ypan.sprinbootweb1.entities.User;
import com.ypan.sprinbootweb1.mapper.UserMapper;
import com.ypan.sprinbootweb1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public User selectUserByNamePwd(User user) {
        return userMapper.selectUserByNamePwd(user);
    }

    @Override
    public User addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User selectUserById(Integer userId) {
        return userMapper.selectUserById(userId);
    }
}
