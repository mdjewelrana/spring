/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.service;

import com.rana.book.dao.InBookListDAO;
import com.rana.book.domain.BookList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author B2
 */
@Service
public class BookListService implements InBookListService {

    @Autowired
    private InBookListDAO bookListDAO;

    @Override
    public List<BookList> getAllObject() {
        return bookListDAO.getAllObject();
    }

    @Override
    public BookList getObjectById(int id) {
        BookList obj = bookListDAO.getObjectById(id);
        return obj;
    }

    @Override
    public boolean addObject(BookList obj) {
      if (bookListDAO.objectExists(obj.getBookTitle()))   {
            return false;
        } else {
            bookListDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(BookList obj) {
        bookListDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        bookListDAO.deleteObject(id);
    }

}
