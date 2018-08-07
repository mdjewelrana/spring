/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.controller;

import com.rana.book.domain.Publisher;
import com.rana.book.domain.User;
import com.rana.book.service.InPublisherService;
import com.rana.book.service.InUserService;
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

/**
 *
 * @author B2
 */
@Controller
@RequestMapping("/pub")
public class PublisherController {
     @Autowired
private InPublisherService publisherService;
  @RequestMapping("/home")
    public String home() {
        return "publisher";
    }
     @RequestMapping(value = "/publisher/{id}", method = RequestMethod.GET)
    public ResponseEntity<Publisher>getObjectById(@PathVariable("id") Integer id) {
        Publisher publisher = publisherService.getObjectById(id);
        return new ResponseEntity<Publisher>(publisher, HttpStatus.OK);
    }

    @RequestMapping(value = "/publisher", method = RequestMethod.GET)
    public ResponseEntity<List<Publisher>> getAllObject() {
        List<Publisher> list = publisherService.getAllObject();
        return new ResponseEntity<List<Publisher>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/publisher", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody Publisher publisher, UriComponentsBuilder builder) {
        boolean flag = publisherService.addObject(publisher);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/publisher/{id}").buildAndExpand(publisher.getPubId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/publisher/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Publisher> updateObject(@RequestBody Publisher user) {
        publisherService.updateObject(user);
        return new ResponseEntity<Publisher>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/publisher/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        publisherService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
