package kz.aitu.restpro2423.rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import kz.aitu.restpro2423.rest.entities.*;

@RestController
public class MyController {

    private ObjectMapper oMapper = new ObjectMapper();



    @GetMapping("/main")
    public String myListener() {
        return "Hello World";
    }
    @GetMapping("/main/guest")
    public String GuestListener(){

        Guest gt1 =new Guest("Aiymzhan","Abilgazy","aiymzhangmail.com","877751233221","st.Alikhan Bukeikhan 12", "Atyrau");
        String jsonData = null;
        try{
            jsonData = oMapper.writeValueAsString(gt1);

        }catch(JsonProcessingException e){
            System.out.println("Error system");

        }
        return jsonData;
    }


}
