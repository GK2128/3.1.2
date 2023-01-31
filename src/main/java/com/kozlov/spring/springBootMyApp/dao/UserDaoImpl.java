package com.kozlov.spring.springBootMyApp.dao;

import com.kozlov.spring.springBootMyApp.model.User;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(int id, User updateUser) {

        User userToBeUpdate = show(id);
        userToBeUpdate.setName(updateUser.getName());
        userToBeUpdate.setLastName(updateUser.getLastName());
        userToBeUpdate.setAge(updateUser.getAge());
        userToBeUpdate.setEmail(updateUser.getEmail());
        userToBeUpdate.setPassword(updateUser.getPassword());
        userToBeUpdate.setRole(updateUser.getRole());
    }

    @Override
    public void delete(int id) {
        entityManager.remove(show(id));
    }

}
