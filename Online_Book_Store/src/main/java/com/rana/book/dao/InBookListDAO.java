/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.dao;

import com.rana.book.domain.Author;
import com.rana.book.domain.BookList;
import java.util.List;

/**
 *
 * @author B2
 */
public interface InBookListDAO {
     List<BookList> getAllObject();

    BookList getObjectById(int id);

    void addObject(BookList obj);

    void updateObject(BookList obj);

    void deleteObject(int id);

    boolean objectExists(String title);
    
}
