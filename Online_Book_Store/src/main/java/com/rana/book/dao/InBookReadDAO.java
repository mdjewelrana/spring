/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.dao;

import com.rana.book.domain.Author;
import com.rana.book.domain.BookRead;
import java.util.List;

/**
 *
 * @author B2
 */
public interface InBookReadDAO {
     List<BookRead> getAllObject();

    BookRead getObjectById(int id);

    void addObject(BookRead obj);

    void updateObject(BookRead obj);

    void deleteObject(int id);

    boolean objectExists(String name);
}
