/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.service;

import com.rana.book.dao.InAuthorDAO;
import com.rana.book.dao.InImageDAO;
import com.rana.book.domain.Image;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author B2
 */
@Service
public class ImageService implements InImageService {

    @Autowired
    private InImageDAO imageDAO;

    @Override
    public List<Image> getAllObject() {
        return imageDAO.getAllObject();
    }

    @Override
    public Image getObjectById(int id) {
        Image obj = imageDAO.getObjectById(id);
        return obj;
    }

    @Override
    public boolean addObject(Image obj) {
        if (imageDAO.objectExists(obj.getImage())) {
            return false;
        } else {
            imageDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(Image obj) {
        imageDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        imageDAO.deleteObject(id);
    }
}
 
