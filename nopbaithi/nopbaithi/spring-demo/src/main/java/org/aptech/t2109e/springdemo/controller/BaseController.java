package org.aptech.t2109e.springdemo.controller;

import org.aptech.t2109e.springdemo.config.properties.CommonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
    @Autowired
    protected CommonProperties commonProperties;
}
