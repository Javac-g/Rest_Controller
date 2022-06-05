package com.MAX.V2.Service;

import com.MAX.V2.Controller.Car;
import com.MAX.V2.Controller.ResponseDTO;

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
    public void log(String filename,ResponseDTO user){

        byte[] data = ("\nName:  " + user.getName()).getBytes();
        try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(filename,true);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)){

            byteArrayOutputStream.write(data);
            byteArrayOutputStream.writeTo(fileOutputStream);
            dataOutputStream.writeUTF("\nId: " + user.getId());
        }catch (IOException e){

            e.printStackTrace();

        }

    }

    public void setEnum(ResponseDTO response, RequestDTO request){

        for (Car x :request.getCarlist()){
            switch (x.getValue()){
                case "A":
                    response.setCarEnum(CarEnum.Aston_Martin);
                    break;
                case "FY":
                    response.setCarEnum(CarEnum.Ferrary);
                    break;
                case "FD":
                    response.setCarEnum(CarEnum.Ford);

            }
        }

    }


    public ResponseDTO create(RequestDTO json){
        ResponseDTO user = new ResponseDTO();
        user.setName(json.getName());
        user.setId(json.getId());
        user.setTool(json.getTool());
        setEnum(user,json);
        log("Created.txt",user);
        datalist.add(user);
        return user;
    }
    public ResponseDTO read(Integer id){

        for (ResponseDTO user: datalist){

            if(user.getId().equals(id)){
                log("Seaarched.txt",user);
                return user;

            }
        }
        return null;
    }
    public ResponseDTO update(Integer id, RequestDTO json){
        ResponseDTO user = read(id);
        if (user!=null){
            user.setName(json.getName());
            user.setId(json.getId());
            user.setTool(json.getTool());
            setEnum(user,json);
            log("Updated.txt",user);
            return user;
        }
        return null;

    }
}
