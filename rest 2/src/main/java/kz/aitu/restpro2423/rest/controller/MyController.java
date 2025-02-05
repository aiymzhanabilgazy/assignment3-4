package kz.aitu.restpro2423.rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.aitu.restpro2423.rest.dbconnection.Dbconnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import kz.aitu.restpro2423.rest.entities.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class MyController {
    @Autowired
    private ObjectMapper obMapper;


  @GetMapping("/get_guests")
    public String getGuests() {
        Dbconnection myConnection = new Dbconnection();
        Connection con = null;
        ArrayList<Guest> guests = new ArrayList<>();

        try{
            con=myConnection.connect();
            guests = myConnection.getGuests(con);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        finally
        {
            try { myConnection.closeConnection(con); }
            catch (SQLException e) { System.out.println("Error: " + e.toString()); }
        }

        String jsonData=null;
        try{
            jsonData = obMapper.writeValueAsString(guests);
        }catch(JsonProcessingException e){
            System.out.println("Some error with guest");
        }
        return jsonData;
  }
  @GetMapping("/find_guests_by_firstname")
    public String findGuestByFirstname(@RequestParam String firstname) {
        Dbconnection myConnection = new Dbconnection();
        Connection con = null;
        Guest g1=null;
        try{
            con = myConnection.connect();
            g1 = myConnection.findGuestByFirstname(con,firstname);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        String jsonData=null;
        try{
            jsonData = obMapper.writeValueAsString(g1);
        }catch(JsonProcessingException e){
            System.out.println("Some error with guest");
        }
        return jsonData;
  }

  @PostMapping("/create_guest")
    public String createGuest(@RequestParam int id,@RequestParam String firstname,
                              @RequestParam String lastname, @RequestParam String email,
                              @RequestParam String phonenumber, @RequestParam String address,
                              @RequestParam String city ) {
        Dbconnection myConnection = new Dbconnection();
        Connection con = null;
        Guest g1=new Guest(id,firstname,lastname,email,phonenumber,address,city);
        String jsonData=null;
        try{
            con = myConnection.connect();
        }catch(Exception e){
            System.out.println(" EXCEPTION 1");
        }
        try{
            jsonData=obMapper.writeValueAsString(myConnection.createGuest(con,g1));
        }catch(JsonProcessingException e){
            System.out.println("Some error with guest");
        }catch (Exception e) {
            System.out.println("Some error with sql guest");
        }
        return jsonData;

  }


@PostMapping("/delete_guest")
    public String deleteGuest(@RequestParam String firstname) {
        Dbconnection myConnection = new Dbconnection();
        Connection con = null;
        Guest g1=null;
        String jsonData=null;
        try{
            con = myConnection.connect();
            g1 = myConnection.findGuestByFirstname(con,firstname);
            System.out.println(g1);
            con=myConnection.connect();
            myConnection.deleteGuest(con,g1);
        }catch(Exception e){
            System.out.println(" EXCEPTION 1");
        }
        try{
            jsonData = obMapper.writeValueAsString(g1);
        } catch(JsonProcessingException e){
            System.out.println("Some error with delete operation");
        }
        return jsonData;
    }
@PostMapping("/update_guest")
public String updateGuest(@RequestParam String firstname,@RequestParam String newFirstname,
                          @RequestParam String newLastname,@RequestParam String newEmail,
                          @RequestParam String newPhonenumber,@RequestParam String newAddress,
                          @RequestParam String newCity) {
    Dbconnection myConnection = new Dbconnection();
    Connection con = null;
    Guest g1 = null;
    String jsonData=null;
    try{
        con = myConnection.connect();
        System.out.println("Connected to database");

        g1 = myConnection.findGuestByFirstname(con,firstname);
        if(g1==null){
            System.out.println("Guest not found");
        }

        g1.setFirstname(newFirstname);
        g1.setLastname(newLastname);
        g1.setEmail(newEmail);
        g1.setPhonenumber(newPhonenumber);
        g1.setAddress(newAddress);
        g1.setCity(newCity);

        g1 = myConnection.updateGuest(con, g1, firstname);
        System.out.println("Updated guest: " + g1);

    }
    catch(Exception e) {
        System.out.println(" EXCEPTION 1");
    }
    try{
        jsonData = obMapper.writeValueAsString (g1);
    } catch (JsonProcessingException e) {
        System.out.println("Some error with update operation");
    }
    return jsonData;
}

}

