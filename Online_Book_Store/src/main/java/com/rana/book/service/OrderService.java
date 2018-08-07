/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.service;

import com.rana.book.dao.InOrderDAO;
import com.rana.book.domain.Order;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author B2
 */
@Service

public class OrderService implements InOrderService {

    @Autowired
    private InOrderDAO inOrderDAO;

    @Override
    public List<Order> getAllObject() {
        return inOrderDAO.getAllObject();
    }

    @Override
    public Order getObjectById(int id) {
        Order obj = inOrderDAO.getObjectById(id);
        return obj;
    }

    @Override
    public boolean addObject(Order obj) {
        if (inOrderDAO.objectExists(obj.getUser().getUserId())) {
            return false;
        } else {
            inOrderDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(Order obj) {
        inOrderDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        inOrderDAO.deleteObject(id);
    }

}
