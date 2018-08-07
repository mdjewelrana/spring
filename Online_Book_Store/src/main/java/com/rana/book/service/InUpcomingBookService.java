/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.service;

import com.rana.book.domain.Author;
import com.rana.book.domain.UpcomingBook;
import java.util.List;

/**
 *
 * @author B2
 */
public interface InUpcomingBookService {
    List<UpcomingBook> getAllObject();

    UpcomingBook getObjectById(int id);

    boolean addObject(UpcomingBook obj);

    void updateObject(UpcomingBook obj);

    void deleteObject(int id);
}
