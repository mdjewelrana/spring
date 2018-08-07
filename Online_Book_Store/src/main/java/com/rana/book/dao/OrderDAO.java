/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.dao;

import com.rana.book.domain.Order;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author B2
 */
@Transactional
@Repository
public class OrderDAO implements InOrderDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Order> getAllObject() {
        String hql = "FROM Order p LEFT JOIN FETCH  p.user LEFT JOIN FETCH  p.bookList ORDER BY p.orderId";
        return (List<Order>) hibernateTemplate.find(hql);
    }

    @Override
    public Order getObjectById(int id) {
        return hibernateTemplate.get(Order.class, id);
    }

    @Override
    public void addObject(Order obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(Order obj) {
        Order t = getObjectById(obj.getOrderId());
        t.setBookList(obj.getBookList());
        t.setUser(obj.getUser());
        t.setOrderDate(obj.getOrderDate());
        t.setOrderStatus(obj.getOrderStatus());
        t.setOrderQty(obj.getOrderQty());

        hibernateTemplate.update(t);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));

    }

    @Override
    public boolean objectExists(int userid) {
        String hql = "FROM Order as p WHERE p.user.userId = ?";
        List<Order> lst = (List<Order>) hibernateTemplate.find(hql, userid);
        return lst.size() > 0 ? true : false;
    }

}
