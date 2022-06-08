package com.MAX.V4.Controller;

import com.MAX.V4.Service.IceCreamENUM;

public class ResponseDTO {
    String name;
    Integer id;
    Tool tool;
    IceCreamENUM creamENUM;

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

    public IceCreamENUM getCreamENUM() {
        return creamENUM;
    }

    public void setCreamENUM(IceCreamENUM creamENUM) {
        this.creamENUM = creamENUM;
    }
}
