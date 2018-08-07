/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.service;

import com.rana.book.dao.InUpcomingBookDAO;
import com.rana.book.domain.UpcomingBook;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author B2
 */
@Service
public class UpcomingBookService implements InUpcomingBookService {

    @Autowired
    private InUpcomingBookDAO upcomingBookDAO;

    @Override
    public List<UpcomingBook> getAllObject() {
        return upcomingBookDAO.getAllObject();
    }

    @Override
    public UpcomingBook getObjectById(int id) {
        UpcomingBook obj = upcomingBookDAO.getObjectById(id);
        return obj;
    }

    @Override
    public boolean addObject(UpcomingBook obj) {
        if (upcomingBookDAO.objectExists(obj.getAuthName())) {
            return false;
        } else {
            upcomingBookDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(UpcomingBook obj) {
        upcomingBookDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        upcomingBookDAO.deleteObject(id);
    }

}
