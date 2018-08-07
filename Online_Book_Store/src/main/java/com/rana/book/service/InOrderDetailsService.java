/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.service;

import com.rana.book.domain.OrderDetails;
import java.util.List;

/**
 *
 * @author B2
 */
public interface InOrderDetailsService {
    List<OrderDetails> getAllObject();

    OrderDetails getObjectById(int id);

    boolean addObject(OrderDetails obj);

    void updateObject(OrderDetails obj);

    void deleteObject(int id);
}
