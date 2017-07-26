package com.example.demo.controller;

import com.example.demo.annotation.Access;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

/**
 * Created by silvester on 2017/7/26.
 */
@RestController
public class HolloController {
    @RequestMapping(value = "/admin",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
    @Access(authorities = {"admin"})
    public String hello(){
        return "hello ,admin!";
    }
}
