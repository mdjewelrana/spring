/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.controller;

import com.rana.book.domain.UpcomingBook;
import com.rana.book.service.InUpcomingBookService;
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
@RequestMapping("/upc")

public class UpcomingBookController {
     @Autowired
private InUpcomingBookService upcomingBookService;
  @RequestMapping("/home")
    public String home() {
        return "upcbook";
    }
     @RequestMapping(value = "/upcoming/{id}", method = RequestMethod.GET)
    public ResponseEntity<UpcomingBook>getObjectById(@PathVariable("id") Integer id) {
        UpcomingBook upcoming = upcomingBookService.getObjectById(id);
        return new ResponseEntity<UpcomingBook>(upcoming, HttpStatus.OK);
    }

    @RequestMapping(value = "/upcoming", method = RequestMethod.GET)
    public ResponseEntity<List<UpcomingBook>> getAllObject() {
        List<UpcomingBook> list = upcomingBookService.getAllObject();
        return new ResponseEntity<List<UpcomingBook>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/upcoming", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody UpcomingBook upcoming, UriComponentsBuilder builder) {
        boolean flag = upcomingBookService.addObject(upcoming);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/upcoming/{id}").buildAndExpand(upcoming.getBookId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/upcoming/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UpcomingBook> updatePerson(@RequestBody UpcomingBook upcoming) {
        upcomingBookService.updateObject(upcoming);
        return new ResponseEntity<UpcomingBook>(upcoming, HttpStatus.OK);
    }

    @RequestMapping(value = "/upcoming/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePerson(@PathVariable("id") Integer id) {
        upcomingBookService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
