/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.service;

import com.rana.book.domain.SubCategory;
import java.util.List;

/**
 *
 * @author B2
 */
public interface InSubCategoryService {
    List<SubCategory> getAllObject();

    SubCategory getObjectById(int id);

    boolean addObject(SubCategory obj);

    void updateObject(SubCategory obj);

    void deleteObject(int id);
}
