package com.MAX.Controller;

import com.MAX.Service.RequestDTO;
import com.MAX.Service.Services;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/XXX")
public class Controller {

    private Services services;

    public Controller(Services services) {
        this.services = services;
    }

    @PostMapping(value = "/a",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO add(@RequestBody RequestDTO user){

        return services.create(user);

    }

}
