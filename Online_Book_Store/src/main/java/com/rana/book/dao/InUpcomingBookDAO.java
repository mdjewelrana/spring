/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.dao;

import com.rana.book.domain.UpcomingBook;
import java.util.List;

/**
 *
 * @author B2
 */
public interface InUpcomingBookDAO {
     List<UpcomingBook> getAllObject();

    UpcomingBook getObjectById(int id);

    void addObject(UpcomingBook obj);

    void updateObject(UpcomingBook obj);

    void deleteObject(int id);

    boolean objectExists(String name);
}
