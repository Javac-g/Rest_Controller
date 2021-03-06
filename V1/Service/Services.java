package com.MAX.V1.Service;

import com.MAX.V1.Controller.Car;
import com.MAX.V1.Controller.ResponseDTO;

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

    public ResponseDTO update(Integer id, RequestDTO json){
        ResponseDTO userTwo = read(id);

        if (userTwo != null){

            setEnum(userTwo,json);

            userTwo.setName(json.getName());

            userTwo.setId(json.getId());

            userTwo.setTool(json.getTool());

            log("Update",userTwo);

            return userTwo;
        }
        return null;
    }

    public Integer delete(Integer id){

        int R = -1;

        for (int i = 0; i < database.size(); i++){

            if (database.get(i).getId().equals(id)){

                log("Delete",database.get(i));

                R = i;

            }
        }
        if (R != -1){

            database.remove(R);

            return R;

        }
        return null;
    }

}
