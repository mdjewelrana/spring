/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.dao;

import com.rana.book.domain.UserRole;
import java.util.List;

/**
 *
 * @author B2
 */
public interface InRoleDAO {
    List<UserRole> getAllObject();

    UserRole getObjectById(int id);

    void addObject(UserRole obj);

    void updateObject(UserRole obj);

    void deleteObject(int id);

    boolean objectExists(String name);
    
}
