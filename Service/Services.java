package com.MAX.Service;

import com.MAX.Controller.Car;
import com.MAX.Controller.ResponseDTO;
import com.fasterxml.jackson.core.io.DataOutputAsStream;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Services {
    List<ResponseDTO> database = new ArrayList<>();



    public String print(String msg){

        return msg;

    }
    public void log(String filename, ResponseDTO user){

        byte[] data = ("\nName: " + user.getName() + "\nId: " + user.getId()).getBytes();

        try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filename + ".dat",true)) ;

            FileOutputStream fileOutputStream = new FileOutputStream(filename + ".txt" , true)){


            byteArrayOutputStream.write(data);

            byteArrayOutputStream.writeTo(fileOutputStream);

            dataOutputStream.writeUTF("\nName: " + user.getName() + "\nId: " + user.getId());

        }catch (IOException e){
            e.printStackTrace();

        }


    }

    public ResponseDTO setEnum(ResponseDTO response, RequestDTO request){

        for (Car car:request.getCarlist()){
            switch (car.getValue()){
                case "A":
                    response.setCarEnum(CarEnum.Audi);
                    break;
                case "B":
                    response.setCarEnum(CarEnum.Bmw);
                    break;
                case "F":
                    response.setCarEnum(CarEnum.Ferrari);
                    break;
            }
        }
        return response;




    }

    public ResponseDTO create(RequestDTO json){
        ResponseDTO user = new ResponseDTO();
        setEnum(user,json);

        user.setName(json.getName());
        user.setId(json.getId());
        user.setTool(json.getTool());

        log("Created",user);
        database.add(user);
        return user;
    }
    public ResponseDTO read(Integer id){
        for (ResponseDTO x: database){
            if (x.getId().equals(id)){

                log("Search",x);

                return x;
            }
        }
        return null;
    }

}
