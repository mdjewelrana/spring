/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.dao;

import com.rana.book.domain.Image;
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
public class ImageDAO implements InImageDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
    @Override
    public List<Image> getAllObject() {
        String hql = "FROM Image p LEFT JOIN FETCH  p.bookList ORDER BY p.imageId";
        return (List<Image>) hibernateTemplate.find(hql);
    }

    @Override
    public Image getObjectById(int id) {
        return hibernateTemplate.get(Image.class, id);
    }

    @Override
    public void addObject(Image obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(Image obj) {
        Image a = getObjectById(obj.getImageId());
        a.setImageName(obj.getImageName());
        a.setImage(obj.getImage());
        a.setBookList(obj.getBookList());
        hibernateTemplate.update(a);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(String image) {
        String hql = "FROM Image as p WHERE p.image = ?";
        List<Image> lst = (List<Image>) hibernateTemplate.find(hql, image);
        return lst.size() > 0 ? true : false;
    }

}
