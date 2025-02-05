package kz.aitu.restpro2423.rest.entities;

public class Guest extends Person {
    /// Attributes specific to Guest
    private String address;
    private String city;
    public Guest() {}

    /// main constructor
    public Guest(int id,String firstname,String lastname,String email,String phonenumber,String address,String city){
        super(id,firstname,lastname,phonenumber,email);
        this.address = address;
        this.city = city;
    }

    /// getters
    public String getAddress(){
        return address;
    }
    public String getCity(){
        return city;
    }

    /// setters
    public void setAddress(String address){
        this.address = address;
    }
    public void setCity(String city){
        this.city = city;
    }


    /// Overriding toString()
    @Override
    public String toString(){
        return super.toString()+", Address:" + address + ", City:" + city;
    }
}


