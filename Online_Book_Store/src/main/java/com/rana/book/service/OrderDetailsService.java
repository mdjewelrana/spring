/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.service;

import com.rana.book.dao.InOrderDetailsDAO;
import com.rana.book.domain.OrderDetails;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author B2
 */
@Service
public class OrderDetailsService implements InOrderDetailsService {

    @Autowired
    private InOrderDetailsDAO detailsDAO;

    @Override
    public List<OrderDetails> getAllObject() {
        return detailsDAO.getAllObject();
    }

    @Override
    public OrderDetails getObjectById(int id) {
        OrderDetails obj = detailsDAO.getObjectById(id);
        return obj;
    }

    @Override
    public boolean addObject(OrderDetails obj) {
        if (detailsDAO.objectExists(obj.getOrder().getOrderId())) {
            return false;
        } else {
            detailsDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(OrderDetails obj) {
        detailsDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        detailsDAO.deleteObject(id);
    }

}
