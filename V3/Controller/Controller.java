package com.MAX.V3.Controller;

import com.MAX.V3.Services.RequestDTO;
import com.MAX.V3.Services.Services;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/alpha")
public class Controller {
    private Services services;
    @PostMapping(value = "/a",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO addData(@RequestBody RequestDTO user){
        return services.create(user);
    }
    @GetMapping(value = "/f",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO findData(@RequestParam Integer id){
        return services.read(id);
    }
}
