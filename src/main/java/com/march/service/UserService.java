package com.march.service;

import com.march.domain.User;
import com.march.mapper.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@description: TODO
 *@see: UserService
 *@createTime: 2020/5/19 1:53
 *@version:1.0
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public void insert(User user){
        userDAO.insert(user);
    }

    public User selectUserById(int id){
        return userDAO.selectByPrimaryKey(id);
    }
}
