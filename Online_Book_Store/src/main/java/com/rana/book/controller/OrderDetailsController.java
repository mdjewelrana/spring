/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.controller;

import com.rana.book.domain.BookList;
import com.rana.book.domain.OrderDetails;
import com.rana.book.service.InBookListService;
import com.rana.book.service.InOrderDetailsService;
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
@RequestMapping("/ode")
public class OrderDetailsController {
    @Autowired
private InOrderDetailsService detailsService;
  @RequestMapping("/home")
    public String home() {
        return "orderdetails";
    }
     @RequestMapping(value = "/odetails/{id}", method = RequestMethod.GET)
    public ResponseEntity<OrderDetails>getObjectById(@PathVariable("id") Integer id) {
        OrderDetails odetails = detailsService.getObjectById(id);
        return new ResponseEntity<OrderDetails>(odetails, HttpStatus.OK);
    }

    @RequestMapping(value = "/odetails", method = RequestMethod.GET)
    public ResponseEntity<List<OrderDetails>> getAllObject() {
        List<OrderDetails> list = detailsService.getAllObject();
        return new ResponseEntity<List<OrderDetails>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/odetails", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody OrderDetails odetails, UriComponentsBuilder builder) {
        boolean flag = detailsService.addObject(odetails);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/odetails/{id}").buildAndExpand(odetails.getOrderDetailId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/odetails/{id}", method = RequestMethod.PUT)
    public ResponseEntity<OrderDetails> updateObject(@RequestBody OrderDetails odetails) {
        detailsService.updateObject(odetails);
        return new ResponseEntity<OrderDetails>(odetails, HttpStatus.OK);
    }

    @RequestMapping(value = "/odetails/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        detailsService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
