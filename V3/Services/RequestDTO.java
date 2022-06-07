package com.MAX.V3.Services;

import com.MAX.V3.Controller.Pet;
import com.MAX.V3.Controller.Tool;

import java.util.ArrayList;
import java.util.List;

public class RequestDTO {

    String name;
    Integer id;
    Tool tool;
    List<Pet> petlist = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public List<Pet> getPetlist() {
        return petlist;
    }

    public void setPetlist(List<Pet> petlist) {
        this.petlist = petlist;
    }
}
