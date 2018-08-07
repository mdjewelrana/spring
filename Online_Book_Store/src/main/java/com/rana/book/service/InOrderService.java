/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.service;

import com.rana.book.domain.Order;
import java.util.List;

/**
 *
 * @author B2
 */
public interface InOrderService {
        List<Order> getAllObject();

    Order getObjectById(int id);

    boolean addObject(Order obj);

    void updateObject(Order obj);

    void deleteObject(int id);
}
