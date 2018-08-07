/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.dao;

import com.rana.book.domain.BookList;
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
public class BookListDAO implements InBookListDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")

    @Override
    public List<BookList> getAllObject() {
        String hql = "FROM BookList p LEFT JOIN FETCH  p.author LEFT JOIN FETCH  p.category LEFT JOIN FETCH  p.publisher LEFT JOIN FETCH  p.subCategory ORDER BY p.bookId";
        return (List<BookList>) hibernateTemplate.find(hql);
    }

    @Override
    public BookList getObjectById(int id) {
        return hibernateTemplate.get(BookList.class, id);
    }

    @Override
    public void addObject(BookList obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(BookList obj) {
        BookList u = getObjectById(obj.getBookId());
        u.setAuthor(obj.getAuthor());
        u.setBookDiscount(obj.getBookDiscount());
        u.setBookPrice(obj.getBookPrice());
        u.setBookUrl(obj.getBookUrl());
        u.setBookTitle(obj.getBookTitle());
        u.setCategory(obj.getCategory()); 
        u.setPublisher(obj.getPublisher());
        u.setSubCategory(obj.getSubCategory());
        u.setBookStatus(obj.getBookStatus());
        hibernateTemplate.update(u);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(String title) {
        String hql = "FROM BookList as p WHERE p.bookTitle = ?";
        List<BookList> lst = (List<BookList>) hibernateTemplate.find(hql, title);
        return lst.size() > 0 ? true : false;
    }
}
