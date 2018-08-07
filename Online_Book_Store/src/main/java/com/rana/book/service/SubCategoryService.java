/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.service;

import com.rana.book.dao.InSubCategoryDAO;
import com.rana.book.domain.SubCategory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author B2
 */
@Service
public class SubCategoryService implements InSubCategoryService {

    @Autowired
    private InSubCategoryDAO subCategoryDAO;

    @Override
    public List<SubCategory> getAllObject() {
        return subCategoryDAO.getAllObject();
    }

    @Override
    public SubCategory getObjectById(int id) {
        SubCategory obj = subCategoryDAO.getObjectById(id);
        return obj;
    }

    @Override
    public boolean  addObject(SubCategory obj) {
        if (subCategoryDAO.objectExists(obj.getCategory().getCatId(), obj.getSubCatName())) {
            return false;
        } else {
            subCategoryDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(SubCategory obj) {
        subCategoryDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        subCategoryDAO.deleteObject(id);
    }

}
