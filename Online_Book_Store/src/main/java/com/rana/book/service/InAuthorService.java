/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.service;

import com.rana.book.domain.Author;
import java.util.List;

/**
 *
 * @author B2
 */

public interface InAuthorService {
    List<Author> getAllObject();

    Author getObjectById(int id);

    boolean addObject(Author obj);

    void updateObject(Author obj);

    void deleteObject(int id);
}
