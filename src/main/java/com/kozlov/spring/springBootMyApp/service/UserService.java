package com.kozlov.spring.springBootMyApp.service;



import com.kozlov.spring.springBootMyApp.model.User;

import java.util.List;

public interface UserService {
    List<User> index();

    void save(User user);

    User show(int id);

    void update(int id, User updateUser);

    void delete(int id);
}
