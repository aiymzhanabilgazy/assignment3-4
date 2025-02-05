package kz.aitu.restpro2423.rest.entities;

public class Person {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String phonenumber;

    public Person() {}

    /// main constructor
    public Person(int id,String firstname, String lastname, String email, String phonenumber){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phonenumber = phonenumber;
    }

    /// getters and setters
    public int getId() {
        return id;
    }
    public String getFirstname(){
        return firstname;
    }
    public String getLastname(){
        return lastname;
    }
    public String getEmail() {
        return email;
    }
    public String getPhonenumber(){
        return phonenumber;
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhonenumber(String phoneNumber){
        this.phonenumber = phonenumber;
    }

    /// Overriding toString()
    @Override
    public String toString(){
        return "Id:"+ id + " "+" Name:" + firstname + " " + lastname  + ", Email: " + email  + ", Phone: " + phonenumber;
    }
    /// Overriding equals()
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person)obj;
        return firstname.equals(person.firstname) && lastname.equals(person.lastname) && email.equals(person.email) && phonenumber.equals(person.phonenumber);
    }

    /// Overriding hashCode()
    @Override
    public int hashCode() {
        return firstname.hashCode() + lastname.hashCode() + email.hashCode() + phonenumber.hashCode();
    }
}