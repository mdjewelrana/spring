/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rana.book.controller;

import com.rana.book.domain.UserRole;
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
 * @author B2
 */
@Controller
@RequestMapping("/role")
public class RoleController {
  @Autowired
private InRoleService adminService;
  @RequestMapping("/home")
    public String home() {
        return "role";
    }
     @RequestMapping(value = "/admin/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserRole>getObjectById(@PathVariable("id") Integer id) {
        UserRole admin = adminService.getObjectById(id);
        return new ResponseEntity<UserRole>(admin, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ResponseEntity<List<UserRole>> getAllObject() {
        List<UserRole> list = adminService.getAllObject();
        return new ResponseEntity<List<UserRole>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody UserRole admin, UriComponentsBuilder builder) {
        boolean flag = adminService.addObject(admin);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/admin/{id}").buildAndExpand(admin.getRoleId()
        ).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserRole> updateRole(@RequestBody UserRole admin) {
        adminService.updateObject(admin);
        return new ResponseEntity<UserRole>(admin, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePerson(@PathVariable("id") Integer id) {
        adminService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
