/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.service;

import com.rana.book.domain.Author;
import com.rana.book.domain.Category;
import java.util.List;

/**
 *
 * @author B2
 */
public interface InCategoryService {
     List<Category> getAllObject();

    Category getObjectById(int id);

    boolean addObject(Category obj);

    void updateObject(Category obj);

    void deleteObject(int id);
}
