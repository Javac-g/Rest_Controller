package com.MAX.V2.Controller;

import com.MAX.V2.Service.RequestDTO;
import com.MAX.V2.Service.Services;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/App")
public class Controllers {
    private Services services;

    public Controllers(Services services) {
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

        return services.read(id);

    }
    @PutMapping(value = "/u",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO update(@RequestParam Integer id,@RequestBody RequestDTO user){

        return services.update(id,user);

    }
    @DeleteMapping(value = "/d1",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String delete_One(@RequestParam Integer id){

        return services.print("Deleted person №") + services.deleteA(id);

    }
    @DeleteMapping(value = "/d2",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String delete_Two(@RequestParam Integer id){

        return services.print("Deleted person №") + services.deleteB(id);

    }
}
