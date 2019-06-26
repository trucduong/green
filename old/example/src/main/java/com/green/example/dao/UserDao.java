package com.green.example.dao;

import com.green.example.entities.User;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends AbstractDao<String, User> {

}
