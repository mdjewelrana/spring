/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.dao;

import com.rana.book.domain.Author;
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
public class AuthorDAO implements InAuthorDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
    @Override
    public List<Author> getAllObject() {
        String hql = "FROM Author as p ORDER BY p.authId";
        return (List<Author>) hibernateTemplate.find(hql);
    }

    @Override
    public Author getObjectById(int id) {
        return hibernateTemplate.get(Author.class, id);
    }

    @Override
    public void addObject(Author obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(Author obj) {
        Author a = getObjectById(obj.getAuthId());
        a.setAuthName(obj.getAuthName());
        a.setBookLists(obj.getBookLists());
        hibernateTemplate.update(a);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(String name) {
        String hql = "FROM Author as p WHERE p.authName = ?";
        List<Author> lst = (List<Author>) hibernateTemplate.find(hql, name);
        return lst.size() > 0 ? true : false;
    }

}
