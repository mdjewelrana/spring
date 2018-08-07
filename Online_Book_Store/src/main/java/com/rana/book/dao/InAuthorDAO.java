/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.dao;

import com.rana.book.domain.Author;
import java.util.List;

/**
 *
 * @author B2
 */
public interface InAuthorDAO {
     List<Author> getAllObject();

    Author getObjectById(int id);

    void addObject(Author obj);

    void updateObject(Author obj);

    void deleteObject(int id);

    boolean objectExists(String name);
}
