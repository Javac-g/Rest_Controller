package com.MAX.V4.Controller;

import com.MAX.V4.Service.RequestDTO;
import com.MAX.V4.Service.Services;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(value = "/f", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO find(@RequestParam Integer id){
        return make.read(id);

    }

    @PutMapping(value = "/u",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO update(@RequestParam Integer id,@RequestBody RequestDTO json){

        return make.update(id, json);

    }
    @DeleteMapping(value = "/d",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String delete(@RequestParam Integer id){

        return make.print("Was deleted person number: ") + make.delete(id);

    }
}
