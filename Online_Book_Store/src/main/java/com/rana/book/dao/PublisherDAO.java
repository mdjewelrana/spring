/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.dao;

import com.rana.book.domain.Publisher;
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
public class PublisherDAO implements InPublisherDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")

    @Override
    public List<Publisher> getAllObject() {
        String hql = "FROM Publisher as p ORDER BY p.pubId";
        return (List<Publisher>) hibernateTemplate.find(hql);
    }

    @Override
    public Publisher getObjectById(int id) {
        return hibernateTemplate.get(Publisher.class, id);
    }

    @Override
    public void addObject(Publisher obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(Publisher obj) {
        Publisher u = getObjectById(obj.getPubId());
        u.setPubAddress(obj.getPubAddress());
        u.setPubContact(obj.getPubContact());
        u.setPubCountry(obj.getPubCountry());
        u.setPubName(obj.getPubName());
        u.setBookLists(obj.getBookLists());

        hibernateTemplate.update(u);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(String name) {
        String hql = "FROM Publisher as p WHERE p.pubName = ?";
        List<Publisher> lst = (List<Publisher>) hibernateTemplate.find(hql, name);
        return lst.size() > 0 ? true : false;
    }

}
