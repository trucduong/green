package com.green.example.service;

import com.green.example.dao.UserDao;
import com.green.example.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao dao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findByUserName(String userName) {
        User user = dao.getByKey(userName);
        return user;
    }

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.persist(user);
    }

    public void updateUser(String userName, User user) {
        User entity = dao.getByKey(userName);
        if(entity!=null){
            if(!user.getPassword().equals(entity.getPassword())){
                entity.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            entity.setFullName(user.getFullName());
            entity.setRoles(user.getRoles());
        }
    }

    public List<User> findAllUsers() {
        return dao.getAll();
    }

    public boolean isUserUnique(String userName) {
        User user = dao.getByKey(userName);
        return user == null;
    }

    public void deleteUser(String userName) {
        User entity = dao.getByKey(userName);
        if (entity != null) {
            dao.delete(entity);
        }
    }

}
