package kz.aitu.restpro2423.rest.entities;

public class Person {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    /// main constructor
    public Person(String firstName, String lastName, String email, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    /// getters and setters
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setFirstName(String fistName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    /// Overriding toString()
    @Override
    public String toString(){
        return " Name:" + firstName + " " + lastName  + ", Email: " + email  + ", Phone: " + phoneNumber;
    }
    /// Overriding equals()
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person)obj;
        return firstName.equals(person.firstName) && lastName.equals(person.lastName) && email.equals(person.email) && phoneNumber.equals(person.phoneNumber);
    }

    /// Overriding hashCode()
    @Override
    public int hashCode() {
        return firstName.hashCode() + lastName.hashCode() + email.hashCode() + phoneNumber.hashCode();
    }
}