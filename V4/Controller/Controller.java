package com.MAX.V4.Controller;

import com.MAX.V4.Service.RequestDTO;
import com.MAX.V4.Service.Services;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/beta")
public class Controller {

    private Services make;

    public Controller(Services make){

        this.make = make;

    }

    @PostMapping(value = "/a",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO add(@RequestBody RequestDTO user){

        return make.create(user);

    }
}
