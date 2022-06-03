package com.MAX.Service;

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
}
