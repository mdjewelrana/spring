/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.dao;


import com.rana.book.domain.User;
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
public class UserDAO implements InUserDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllObject() {
        String hql = "FROM User as p LEFT JOIN FETCH p.userRole ORDER BY p.userId";
        return (List<User>) hibernateTemplate.find(hql);
    }

    @Override
    public User getObjectById(int id) {
        return hibernateTemplate.get(User.class, id);
    }

    @Override
    public void addObject(User obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(User obj) {
        User u = getObjectById(obj.getUserId());
        u.setUserRole(obj.getUserRole());
        u.setUserName(obj.getUserName());
        u.setUserAddress(obj.getUserAddress());
        u.setEmail(obj.getEmail());
        u.setGender(obj.getGender());
        u.setOrders(obj.getOrders());
        u.setPassword(obj.getPassword());
        u.setPhone(obj.getPhone());
        u.setRegDate(obj.getRegDate());
        hibernateTemplate.update(u);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean objectExists(String name, String pass) {
        String hql = "FROM User as p WHERE p.userName = ? and p.password = ?";
        List<User> lst = (List<User>) hibernateTemplate.find(hql, name, pass);
        return lst.size() > 0 ? true : false;
    }

}
