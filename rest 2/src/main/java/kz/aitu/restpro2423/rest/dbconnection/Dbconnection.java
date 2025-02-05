package kz.aitu.restpro2423.rest.dbconnection;

import kz.aitu.restpro2423.rest.entities.Guest;
import kz.aitu.restpro2423.rest.entities.Guest;

import java.sql.*;
import java.util.ArrayList;


public class Dbconnection {

    private String url = "jdbc:postgresql://localhost:5432/postgres";
    //table details
    private String username = "postgres";//MySQL credentials
    private String password = "12345678";

    public void getConnectionToDb() throws Exception{
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection Established successfully");
        String query  = "SELECT * FROM tests.guests";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        String firstname = rs.getString("firstname");
        System.out.println(firstname);
        st.close();
        con.close();
        System.out.println("Connection closed ...");
    }

    public Connection connect() throws SQLException{
      Connection con = DriverManager.getConnection(url, username, password);
      System.out.println("Connection Established successfully");
      return con;
    }
    public int closeConnection(Connection con) throws SQLException{
        if(con != null){
            con.close();
            System.out.println("Connection Closed ... .");
            return 0;
        }
        System.out.println("Connection is null... .");
        return 1;
    }

    public ArrayList<Guest> getGuests(Connection con) throws SQLException{
        String query = "select * from tests.guests";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Guest> guests = new ArrayList<Guest>();

        while(rs.next()){
            Guest guest=new Guest();
            guest.setId(rs.getInt("id"));
            guest.setFirstname(rs.getString("firstname"));
            guest.setLastname(rs.getString("lastname"));
            guest.setEmail(rs.getString("email"));
            guest.setPhonenumber(rs.getString("phonenumber"));
            guest.setAddress(rs.getString("address"));
            guest.setCity(rs.getString("city"));
            guests.add(guest);
        }
        st.close();

        return guests;
    }
    public Guest findGuestByFirstname(Connection con, String firstname) throws SQLException{
        String query = "SELECT * FROM tests.guests WHERE firstname = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1,firstname);

        ResultSet rs = st.executeQuery();

        ArrayList<Guest> guests = new ArrayList<Guest>();
        Guest guest=new Guest();
        while(rs.next()){

            guest.setId(rs.getInt("id"));
            guest.setFirstname(rs.getString("firstname"));
            guest.setLastname(rs.getString("lastname"));
            guest.setEmail(rs.getString("email"));
            guest.setPhonenumber(rs.getString("phonenumber"));
            guest.setAddress(rs.getString("address"));
            guest.setCity(rs.getString("city"));
            guests.add(guest);
        }
        st.close();

        return guest;

    }
    public Guest createGuest(Connection con, Guest g) throws SQLException {
        String query = "INSERT INTO tests.guests(id,firstname,lastname,email,phonenumber,address,city) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, g.getId());
        st.setString(2, g.getFirstname());
        st.setString(3, g.getLastname());
        st.setString(4, g.getEmail());
        st.setString(5, g.getPhonenumber());
        st.setString(6, g.getAddress());
        st.setString(7, g.getCity());

        int success = st.executeUpdate();
        st.close();

        if (success > 0) {
            System.out.println("Guest is added successfully");
            return g;
        }
        return null;
    }
    public Guest updateGuest(Connection con, Guest g, String oldFirstname) throws SQLException {
        String query = "UPDATE tests.guests SET  firstname = ?,lastname = ?,email = ?,phonenumber = ?,address = ?,city = ? WHERE firstname= ?";
        PreparedStatement st = con.prepareStatement(query);

        st.setString(1, g.getFirstname());
        st.setString(2, g.getLastname());
        st.setString(3, g.getEmail());
        st.setString(4, g.getPhonenumber());
        st.setString(5, g.getAddress());
        st.setString(6, g.getCity());
        st.setString(7, oldFirstname);

        int success = st.executeUpdate();
        st.close();
        closeConnection(con);

        if (success > 0) {
            System.out.println("Guest is updated successfully");
            return g;
        }
        return null;
    }
    public Guest deleteGuest(Connection con, Guest g) throws SQLException {

        String query = "DELETE FROM tests.guests WHERE firstname = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, g.getFirstname());

        int success = st.executeUpdate();
        st.close();
        closeConnection(con);
        if (success > 0) {
            System.out.println("Guest is deleted successfully");
            return g;
        }
        return null;
    }
}


