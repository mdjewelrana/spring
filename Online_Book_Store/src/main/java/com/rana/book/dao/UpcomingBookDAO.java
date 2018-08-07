/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.dao;

import com.rana.book.domain.UpcomingBook;
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
public class UpcomingBookDAO implements InUpcomingBookDAO{
 @Autowired
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
    @Override
    public List<UpcomingBook> getAllObject() {
 String hql = "FROM UpcomingBook as p ORDER BY p.bookId";
        return (List<UpcomingBook>) hibernateTemplate.find(hql);    }

    @Override
    public UpcomingBook getObjectById(int id) {
        return hibernateTemplate.get(UpcomingBook.class, id);
    }

    @Override
    public void addObject(UpcomingBook obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(UpcomingBook obj) {
 UpcomingBook a = getObjectById(obj.getBookId());
        a.setAuthName(obj.getAuthName());
        a.setPDate(obj.getPDate());
        hibernateTemplate.update(a);    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(String name) {
String hql = "FROM UpcomingBook as p WHERE p.authName = ?";
        List<UpcomingBook> lst = (List<UpcomingBook>) hibernateTemplate.find(hql, name);
        return lst.size() > 0 ? true : false;    }
    
}
