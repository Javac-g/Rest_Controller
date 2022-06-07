package com.MAX.V3.Services;

import com.MAX.V3.Controller.Pet;
import com.MAX.V3.Controller.ResponseDTO;

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
        byte[] data = ("\nName: " + user.getName()).getBytes();

        try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(filename,true);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)){

            byteArrayOutputStream.write(data);
            byteArrayOutputStream.writeTo(fileOutputStream);
            dataOutputStream.writeUTF("\t\nID: " + user.getId());


        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void setEnum(ResponseDTO user, RequestDTO json){
        for (Pet pet :json.getPetlist()){
            switch (pet.getValue()){
                case "C" :
                    user.setPetEnum(PetEnum.CAT);
                    break;
                case "D" :
                    user.setPetEnum(PetEnum.DOG);
                    break;
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
        database.add(user);
        return user;
    }
}
