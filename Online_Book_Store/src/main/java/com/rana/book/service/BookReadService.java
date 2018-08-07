/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.service;

import com.rana.book.dao.InBookReadDAO;
import com.rana.book.domain.BookRead;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author B2
 */
@Service
public class BookReadService implements InBookReadService {

    @Autowired
    private InBookReadDAO bookReadDAO;

    @Override
    public List<BookRead> getAllObject() {
        return bookReadDAO.getAllObject();
    }

    @Override
    public BookRead getObjectById(int id) {
        BookRead obj = bookReadDAO.getObjectById(id);
        return obj;
    }

    @Override
    public boolean addObject(BookRead obj) {
        if (bookReadDAO.objectExists(obj.getBookNam())) {
            return false;
        } else {
            bookReadDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(BookRead obj) {
        bookReadDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        bookReadDAO.deleteObject(id);
    }

}
