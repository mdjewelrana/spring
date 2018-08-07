/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.controller;


import com.rana.book.domain.Image;
import com.rana.book.service.InImageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;
import com.rana.book.service.InRoleService;

/**
 *
 * @author ASUS
 */
@Controller
@RequestMapping("/ima")
public class ImageController {
     @Autowired
private InImageService imageService;
  @RequestMapping("/home")
    public String home() {
        return "image";
    }
     @RequestMapping(value = "/image/{id}", method = RequestMethod.GET)
    public ResponseEntity<Image>getObjectById(@PathVariable("id") Integer id) {
        Image image = imageService.getObjectById(id);
        return new ResponseEntity<Image>(image, HttpStatus.OK);
    }

    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public ResponseEntity<List<Image>> getAllObject() {
        List<Image> list = imageService.getAllObject();
        return new ResponseEntity<List<Image>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/image", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody Image image, UriComponentsBuilder builder) {
        boolean flag = imageService.addObject(image);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/image/{id}").buildAndExpand(image.getImageId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/image/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Image> updatePerson(@RequestBody Image image) {
        imageService.updateObject(image);
        return new ResponseEntity<Image>(image, HttpStatus.OK);
    }

    @RequestMapping(value = "/image/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePerson(@PathVariable("id") Integer id) {
        imageService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
