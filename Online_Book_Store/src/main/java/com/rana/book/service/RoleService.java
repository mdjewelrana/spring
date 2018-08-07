/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rana.book.dao.InRoleDAO;
import com.rana.book.domain.UserRole;

/**
 *
 * @author B2
 */
@Service
public class RoleService implements InRoleService {

    @Autowired
    private InRoleDAO adminDAO;

    @Override
    public List<UserRole> getAllObject() {
        return adminDAO.getAllObject();
    }

    @Override
    public UserRole getObjectById(int id) {
        UserRole obj = adminDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(UserRole obj) {
        if (adminDAO.objectExists(obj.getRoleName()))   {
            return false;
        } else {
            adminDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(UserRole obj) {
        adminDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        adminDAO.deleteObject(id);
    }
}
