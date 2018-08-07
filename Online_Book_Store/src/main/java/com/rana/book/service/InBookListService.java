/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.service;

import com.rana.book.domain.BookList;
import java.util.List;

/**
 *
 * @author B2
 */
public interface InBookListService {
     List<BookList> getAllObject();

    BookList getObjectById(int id);

    boolean addObject(BookList obj);

    void updateObject(BookList obj);

    void deleteObject(int id);
}
