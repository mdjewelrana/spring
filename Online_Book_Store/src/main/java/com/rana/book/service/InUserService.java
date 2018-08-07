/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.service;

import com.rana.book.domain.User;
import java.util.List;

/**
 *
 * @author B2
 */
public interface InUserService {
     List<User> getAllObject();

    User getObjectById(int id);

    boolean addObject(User obj);

    void updateObject(User obj);

    void deleteObject(int id);
}
