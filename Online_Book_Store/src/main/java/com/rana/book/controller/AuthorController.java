/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.controller;

import com.rana.book.domain.Author;
import com.rana.book.domain.User;
import com.rana.book.service.InAuthorService;
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
 * @author ASUS
 */
@Controller
@RequestMapping("/aut")
public class AuthorController {
     @Autowired
private InAuthorService authorService;
  @RequestMapping("/home")
    public String home() {
        return "author";
    }
     @RequestMapping(value = "/author/{id}", method = RequestMethod.GET)
    public ResponseEntity<Author>getObjectById(@PathVariable("id") Integer id) {
        Author author = authorService.getObjectById(id);
        return new ResponseEntity<Author>(author, HttpStatus.OK);
    }

    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public ResponseEntity<List<Author>> getAllObject() {
        List<Author> list = authorService.getAllObject();
        return new ResponseEntity<List<Author>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/author", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody Author author, UriComponentsBuilder builder) {
        boolean flag = authorService.addObject(author);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/author/{id}").buildAndExpand(author.getAuthId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Author> updateObject(@RequestBody Author author) {
        authorService.updateObject(author);
        return new ResponseEntity<Author>(author, HttpStatus.OK);
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePerson(@PathVariable("id") Integer id) {
        authorService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
