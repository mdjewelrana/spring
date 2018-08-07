/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.service;

import com.rana.book.dao.InUserDAO;
import com.rana.book.domain.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author B2
 */
@Service
public class UserService implements InUserService {

    @Autowired
    private InUserDAO userDAO;

    @Override
    public List<User> getAllObject() {
        return userDAO.getAllObject();
    }

    @Override
    public User getObjectById(int id) {
        User obj = userDAO.getObjectById(id);
        return obj;
    }

    @Override
    public boolean addObject(User obj) {
        if (userDAO.objectExists(obj.getUserName(), obj.getPassword())) {
            return false;
        } else {
            userDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(User obj) {
        userDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        userDAO.deleteObject(id);
    }
}
