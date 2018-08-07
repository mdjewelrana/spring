/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.service;

import com.rana.book.dao.InPublisherDAO;
import com.rana.book.dao.InUserDAO;
import com.rana.book.domain.Publisher;
import com.rana.book.domain.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author B2
 */
@Service
public class PublisherService implements InPublisherService{
@Autowired
    private InPublisherDAO publisherDAO;
    @Override
    public List<Publisher> getAllObject() {
return publisherDAO.getAllObject();    }

    @Override
    public Publisher getObjectById(int id) {
Publisher obj = publisherDAO.getObjectById(id);
        return obj;    }

    @Override
    public boolean addObject(Publisher obj) {
if (publisherDAO.objectExists(obj.getPubName()))   {
            return false;
        } else {
            publisherDAO.addObject(obj);
            return true;
        }    }

    @Override
    public void updateObject(Publisher obj) {
publisherDAO.updateObject(obj);    }

    @Override
    public void deleteObject(int id) {
        publisherDAO.deleteObject(id);
    }
    
}
