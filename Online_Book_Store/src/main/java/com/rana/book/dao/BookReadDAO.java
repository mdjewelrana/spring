/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.dao;

import com.rana.book.domain.Author;
import com.rana.book.domain.BookRead;
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
public class BookReadDAO implements InBookReadDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
    @Override
    public List<BookRead> getAllObject() {
        String hql = "FROM BookRead as p ORDER BY p.bookReadId";
        return (List<BookRead>) hibernateTemplate.find(hql);
    }

    @Override
    public BookRead getObjectById(int id) {
        return hibernateTemplate.get(BookRead.class, id);
    }

    @Override
    public void addObject(BookRead obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(BookRead obj) {
        BookRead a = getObjectById(obj.getBookReadId());
        a.setBookNam(obj.getBookNam());
        a.setBookPdf(obj.getBookPdf());
        hibernateTemplate.update(a);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(String name) {
        String hql = "FROM BookRead as p WHERE p.bookNam = ?";
        List<BookRead> lst = (List<BookRead>) hibernateTemplate.find(hql, name);
        return lst.size() > 0 ? true : false;
    }

}
