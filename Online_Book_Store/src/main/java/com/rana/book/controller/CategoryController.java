/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.controller;

import com.rana.book.domain.Category;
import com.rana.book.service.InCategoryService;
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
@RequestMapping("/cat")
public class CategoryController {
    @Autowired
private InCategoryService categoryService;
  @RequestMapping("/home")
    public String home() {
        return "category";
    }
     @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category>getObjectById(@PathVariable("id") Integer id) {
        Category category = categoryService.getObjectById(id);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAllObject() {
        List<Category> list = categoryService.getAllObject();
        return new ResponseEntity<List<Category>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody Category category, UriComponentsBuilder builder) {
        boolean flag = categoryService.addObject(category);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/category/{id}").buildAndExpand(category.getCatId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> updateObject(@RequestBody Category category) {
        categoryService.updateObject(category);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePerson(@PathVariable("id") Integer id) {
        categoryService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
