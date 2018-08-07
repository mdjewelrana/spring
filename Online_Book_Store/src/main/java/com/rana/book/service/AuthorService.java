/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.service;

import com.rana.book.dao.InAuthorDAO;
import com.rana.book.domain.Author;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author B2
 */
@Service
public class AuthorService implements InAuthorService {

    @Autowired
    private InAuthorDAO authorDAO;

    @Override
    public List<Author> getAllObject() {
        return authorDAO.getAllObject();
    }

    @Override
    public Author getObjectById(int id) {
        Author obj = authorDAO.getObjectById(id);
        return obj;
    }

    @Override
    public boolean addObject(Author obj) {
       if (authorDAO.objectExists(obj.getAuthName()))   {
            return false;
        } else {
            authorDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(Author obj) {
        authorDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        authorDAO.deleteObject(id);
    }

}
