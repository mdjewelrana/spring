/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.controller;

import com.rana.book.domain.Author;
import com.rana.book.domain.BookRead;
import com.rana.book.service.InAuthorService;
import com.rana.book.service.InBookReadService;
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
@RequestMapping("/read")
public class BookReadController {
    @Autowired
private InBookReadService bookReadService;
  @RequestMapping("/home")
    public String home() {
        return "readbook";
    }
     @RequestMapping(value = "/readbook/{id}", method = RequestMethod.GET)
    public ResponseEntity<BookRead>getObjectById(@PathVariable("id") Integer id) {
        BookRead readbook = bookReadService.getObjectById(id);
        return new ResponseEntity<BookRead>(readbook, HttpStatus.OK);
    }

    @RequestMapping(value = "/readbook", method = RequestMethod.GET)
    public ResponseEntity<List<BookRead>> getAllObject() {
        List<BookRead> list = bookReadService.getAllObject();
        return new ResponseEntity<List<BookRead>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/readbook", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody BookRead readbook, UriComponentsBuilder builder) {
        boolean flag = bookReadService.addObject(readbook);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/readbook/{id}").buildAndExpand(readbook.getBookReadId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/readbook/{id}", method = RequestMethod.PUT)
    public ResponseEntity<BookRead> updatePerson(@RequestBody BookRead readbook) {
        bookReadService.updateObject(readbook);
        return new ResponseEntity<BookRead>(readbook, HttpStatus.OK);
    }

    @RequestMapping(value = "/readbook/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePerson(@PathVariable("id") Integer id) {
        bookReadService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
