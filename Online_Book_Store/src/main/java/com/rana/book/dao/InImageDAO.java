/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.dao;

import com.rana.book.domain.Image;
import java.util.List;

/**
 *
 * @author B2
 */
public interface InImageDAO {
     List<Image> getAllObject();

    Image getObjectById(int id);

    void addObject(Image obj);

    void updateObject(Image obj);

    void deleteObject(int id);

    boolean objectExists(String image);
}
