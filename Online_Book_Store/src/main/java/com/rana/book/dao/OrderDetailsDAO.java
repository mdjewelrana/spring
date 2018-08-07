/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.dao;

import com.rana.book.domain.OrderDetails;
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
public class OrderDetailsDAO implements InOrderDetailsDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
    @Override
    public List<OrderDetails> getAllObject() {
        String hql = "FROM OrderDetails p LEFT JOIN FETCH  p.bookList LEFT JOIN FETCH  p.order ORDER BY p.orderDetailId";
        return (List<OrderDetails>) hibernateTemplate.find(hql);
    }

    @Override
    public OrderDetails getObjectById(int id) {
        return hibernateTemplate.get(OrderDetails.class, id);
    }

    @Override
    public void addObject(OrderDetails obj) {
        OrderDetails ord = new OrderDetails();
        double price = obj.getBookPrice();
        double total=price*obj.getOrder().getOrderQty();
        double netp=total-total*obj.getBookDiscount()/100;
        ord.setBookList(obj.getBookList());
        ord.setOrder(obj.getOrder());
        ord.setBookPrice(price);
        ord.setBookDiscount(obj.getBookDiscount());
        ord.setBookNetPrice(netp);
        ord.setBookTotalPrice(total);
        hibernateTemplate.save(ord);
    }

    @Override
    public void updateObject(OrderDetails obj) {
        double ntPrice = obj.getOrder().getOrderQty() * obj.getBookPrice() - obj.getBookDiscount() * obj.getOrder().getOrderQty() * obj.getBookPrice() / 100;
        double tPrice = obj.getOrder().getOrderQty() * obj.getBookPrice();
        OrderDetails u = getObjectById(obj.getOrderDetailId());
        u.setBookList(obj.getBookList());
        u.setOrder(obj.getOrder());
        u.setBookDiscount(obj.getBookDiscount());
        u.setBookNetPrice(ntPrice);
        u.setBookPrice(obj.getBookPrice());
        u.setBookTotalPrice(tPrice);

        hibernateTemplate.update(u);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(int obj) {
        String hql = "FROM OrderDetails as p WHERE p.order.orderId = ?";
        List<OrderDetails> lst = (List<OrderDetails>) hibernateTemplate.find(hql, obj);
        return lst.size() > 0 ? true : false;
    }

}
