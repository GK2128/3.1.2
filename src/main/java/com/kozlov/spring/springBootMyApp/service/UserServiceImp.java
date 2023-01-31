package com.kozlov.spring.springBootMyApp.service;

import com.kozlov.spring.springBootMyApp.dao.UserDao;
import com.kozlov.spring.springBootMyApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDAO;

    @Autowired
    public UserServiceImp(UserDao userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    @Transactional
    public List<User> index() {
        return userDAO.index();
    }

    @Override
    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional
    public User show(int id) {
        return userDAO.show(id);
    }

    @Override
    @Transactional
    public void update(int id, User updateUser) {
        userDAO.update(id, updateUser);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDAO.delete(id);
    }
}
