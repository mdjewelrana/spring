/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.dao;

import com.rana.book.domain.OrderDetails;
import java.util.List;

/**
 *
 * @author B2
 */
public interface InOrderDetailsDAO {
     List<OrderDetails> getAllObject();

    OrderDetails getObjectById(int id);

    void addObject(OrderDetails obj);

    void updateObject(OrderDetails obj);

    void deleteObject(int id);

    boolean objectExists(int obj);
}
