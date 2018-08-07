/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.dao;

import com.rana.book.domain.SubCategory;
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
public class SubCategoryDAO implements InSubCategoryDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<SubCategory> getAllObject() {
        String hql = "FROM SubCategory p LEFT JOIN FETCH  p.category ORDER BY p.subCatId";
        return (List<SubCategory>) hibernateTemplate.find(hql);
    }

    @Override
    public SubCategory getObjectById(int id) {
        return hibernateTemplate.get(SubCategory.class, id);
    }

    @Override
    public void addObject(SubCategory obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(SubCategory obj) {
        SubCategory t = getObjectById(obj.getSubCatId());
        t.setCategory(obj.getCategory());
        t.setSubCatDesc(obj.getSubCatDesc());
        t.setSubCatName(obj.getSubCatName());

        hibernateTemplate.update(t);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(int catid, String subcatname) {
        String hql = "FROM SubCategory as p WHERE p.category.catId = ? and p.subCatName=?";
        List<SubCategory> lst = (List<SubCategory>) hibernateTemplate.find(hql, catid, subcatname);
        return lst.size() > 0 ? true : false;
    }

}
