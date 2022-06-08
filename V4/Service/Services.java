package com.MAX.V4.Service;

import com.MAX.V4.Controller.IceCream;
import com.MAX.V4.Controller.ResponseDTO;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Services {
    List<ResponseDTO> datalist = new ArrayList<>();

    public String print(String msg){

        return msg;

    }

    public void log(String type, ResponseDTO user){

        byte[] data = ("\nType: " + type + "\nName: " + user.getName()).getBytes();
        try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            FileOutputStream fileOutputStream = new FileOutputStream("log.dat",true);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)){


            byteArrayOutputStream.write(data);
            byteArrayOutputStream.writeTo(fileOutputStream);
            dataOutputStream.writeUTF("\nId: " + user.getId());

        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public void setEnam(ResponseDTO user, RequestDTO json){
        for (IceCream x : json.getCreamlist()){
            switch (x.getValue()){
                case "R":
                    user.setCreamENUM(IceCreamENUM.RASPBERRY);
                    break;
                case "S":
                    user.setCreamENUM(IceCreamENUM.STRAWBERRY);
                    break;
            }
        }
    }


    public ResponseDTO create(RequestDTO json){
        ResponseDTO user = new ResponseDTO();

        user.setName(json.getName());
        user.setId(json.getId());
        user.setTool(json.getTool());
        setEnam(user,json);
        log("Created",user);
        datalist.add(user);
        return user;
    }

    public ResponseDTO read(Integer id){
        for (ResponseDTO user : datalist){
            if (user.getId().equals(id)){
                log("Searched",user);
                return user;
            }
        }
        return null;
    }









}//eof
