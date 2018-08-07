/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.dao;

import com.rana.book.domain.Author;
import com.rana.book.domain.Category;
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
public class CategoryDAO implements InCategoryDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> getAllObject() {
        String hql = "FROM Category as p ORDER BY p.catId";
        return (List<Category>) hibernateTemplate.find(hql);
    }

    @Override
    public Category getObjectById(int id) {
        return hibernateTemplate.get(Category.class, id);
    }

    @Override
    public void addObject(Category obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(Category obj) {
        Category a = getObjectById(obj.getCatId());
        a.setCatName(obj.getCatName());
        a.setCatDesc(obj.getCatDesc());
        hibernateTemplate.update(a);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(String name) {
        String hql = "FROM Category as p WHERE p.catName = ?";
        List<Category> lst = (List<Category>) hibernateTemplate.find(hql, name);
        return lst.size() > 0 ? true : false;
    }

}
