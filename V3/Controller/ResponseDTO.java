package com.MAX.V3.Controller;

import com.MAX.V3.Services.PetEnum;

public class ResponseDTO {
    String name;
    Integer id;
    Tool tool;
    PetEnum petEnum;

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

    public PetEnum getPetEnum() {
        return petEnum;
    }

    public void setPetEnum(PetEnum petEnum) {
        this.petEnum = petEnum;
    }
}
