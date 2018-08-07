/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.service;

import com.rana.book.dao.InAuthorDAO;
import com.rana.book.dao.InCategoryDAO;
import com.rana.book.domain.Author;
import com.rana.book.domain.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author B2
 */
@Service
public class CategoryService implements InCategoryService{
@Autowired
    private InCategoryDAO categoryDAO;
    @Override
    public List<Category> getAllObject() {
 return categoryDAO.getAllObject();    }

    @Override
    public Category getObjectById(int id) {
 Category obj = categoryDAO.getObjectById(id);
        return obj;    }

    @Override
    public boolean addObject(Category obj) {
if (categoryDAO.objectExists(obj.getCatName()))   {
            return false;
        } else {
            categoryDAO.addObject(obj);
            return true;
        }    }

    @Override
    public void updateObject(Category obj) {
 categoryDAO.updateObject(obj);    }

    @Override
    public void deleteObject(int id) {
        categoryDAO.deleteObject(id);
    }
    
}
