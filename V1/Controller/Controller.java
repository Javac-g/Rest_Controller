package com.MAX.V1.Controller;

import com.MAX.V1.Service.RequestDTO;
import com.MAX.V1.Service.Services;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/f",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO find(@RequestParam Integer id){

        return  services.read(id);

    }
    @PutMapping(value = "/u",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO find(@RequestParam Integer id,@RequestBody RequestDTO user){

        return  services.update(id,user);

    }
    @DeleteMapping(value = "/d",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String delete(@RequestParam Integer id){

        return services.print("Person №") + services.delete(id) + services.print(" was deleted");

    }



}
