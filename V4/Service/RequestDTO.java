package com.MAX.V4.Service;

import com.MAX.V4.Controller.IceCream;
import com.MAX.V4.Controller.Tool;

import java.util.ArrayList;
import java.util.List;

public class RequestDTO {
    String name;
    Integer id;
    Tool tool;
    List<IceCream> creamlist = new ArrayList<>();

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

    public List<IceCream> getCreamlist() {
        return creamlist;
    }

    public void setCreamlist(List<IceCream> creamlist) {
        this.creamlist = creamlist;
    }
}
