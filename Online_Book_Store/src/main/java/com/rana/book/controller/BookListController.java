/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.controller;

import com.rana.book.domain.Author;
import com.rana.book.domain.BookList;
import com.rana.book.service.InAuthorService;
import com.rana.book.service.InBookListService;
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
@RequestMapping("/book")
public class BookListController {
    @Autowired
private InBookListService bookListService;
  @RequestMapping("/home")
    public String home() {
        return "booklist";
    }
     @RequestMapping(value = "/booklist/{id}", method = RequestMethod.GET)
    public ResponseEntity<BookList>getObjectById(@PathVariable("id") Integer id) {
        BookList book = bookListService.getObjectById(id);
        return new ResponseEntity<BookList>(book, HttpStatus.OK);
    }

    @RequestMapping(value = "/booklist", method = RequestMethod.GET)
    public ResponseEntity<List<BookList>> getAllObject() {
        List<BookList> list = bookListService.getAllObject();
        return new ResponseEntity<List<BookList>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/booklist", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody BookList book, UriComponentsBuilder builder) {
        boolean flag = bookListService.addObject(book);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/booklist/{id}").buildAndExpand(book.getBookId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/booklist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<BookList> updateBList(@RequestBody BookList book) {
        bookListService.updateObject(book);
        return new ResponseEntity<BookList>(book, HttpStatus.OK);
    }

    @RequestMapping(value = "/booklist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        bookListService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
