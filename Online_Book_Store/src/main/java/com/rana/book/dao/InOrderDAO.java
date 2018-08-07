/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.dao;

import com.rana.book.domain.Image;
import com.rana.book.domain.Order;
import java.util.List;

/**
 *
 * @author B2
 */
public interface InOrderDAO {
    List<Order> getAllObject();

    Order getObjectById(int id);

    void addObject(Order obj);

    void updateObject(Order obj);

    void deleteObject(int id);

    boolean objectExists(int userid);
}
