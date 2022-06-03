package com.MAX.Service;

import com.MAX.Controller.Car;
import com.MAX.Controller.Tool;

import java.util.ArrayList;
import java.util.List;

public class RequestDTO {
    String name;
    Integer id;
    Tool tool;
    List<Car> carlist = new ArrayList<>();

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

    public List<Car> getCarlist() {
        return carlist;
    }

    public void setCarlist(List<Car> carlist) {
        this.carlist = carlist;
    }
}
