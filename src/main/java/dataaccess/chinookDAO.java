package dataaccess;

import java.sql.*;
import dataaccess.models.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class chinookDAO {
    @Value("${spring.datasource.url}")
    private String url = "jdbc:postgresql://localhost:5432/chinook";
    @Value("${spring.datasource.username}")
    private String username = "postgres";
    @Value("${spring.datasource.password}")
    private String password = "postgres";

    /*
    public chinookDAO(){

    }

    public chinookDAO(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    } */

    /*
    public void test(){
        try(Connection connection = DriverManager.getConnection(url,username,password)){
            System.out.println("Connected to Postgres...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     */

    public void getAllActors(){
        String sql = "SELECT * FROM actor";
        try (Connection connection = DriverManager.getConnection(url,username,password)){
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void getSpecificActor(int id){
        String sql = "SELECT * FROM actor WHERE actor_id = ?";
        try(Connection connection = DriverManager.getConnection(url,username,password)){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet result = statement.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomers(){
        String sql = "SELECT * FROM customer";
        List<Customer>customers = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url,username,password)) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Customer customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("country"),
                        result.getString("postal_code"),
                        result.getString("phone"),
                        result.getString("email")
                );
                customers.add(customer);
                System.out.println(customer);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return customers;
    }

    public Customer getCustomerById(int id){
        Customer customer = null;
        try(Connection connection = DriverManager.getConnection(url,username,password)){
            String sql = "SELECT customer_id, first_name, last_name, country, postal_code, phone, email FROM "
                    + "customer WHERE customer_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("country"),
                        result.getString("postal_code"),
                        result.getString("phone"),
                        result.getString("email"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return customer;
    }

    public int insertCustomer(Customer customer){
        String sql = "INSERT INTO customer(customer_id,first_name,last_name,country,postal_code,phone,email) VALUES (?,?,?,?,?,?,?)";
        int result = 0;
        try(Connection connection = DriverManager.getConnection(url,username,password)){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,customer.id());
            statement.setString(2,customer.firstName());
            statement.setString(3,customer.lastName());
            statement.setString(4,customer.country());
            statement.setString(5,customer.postalCode());
            statement.setString(6,customer.phoneNumber());
            statement.setString(7,customer.email());
            result = statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public Customer getCustomerByFirstName(String firstName){
        Customer customer = null;
        try(Connection connection = DriverManager.getConnection(url,username,password)){
            String sql = "SELECT customer_id, first_name, last_name, country, postal_code, phone, email FROM "
                    + "customer WHERE first_name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,firstName);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("country"),
                        result.getString("postal_code"),
                        result.getString("phone"),
                        result.getString("email"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return customer;
    }

    public Customer getCustomerByLastName(String lastName){
        Customer customer = null;
        try(Connection connection = DriverManager.getConnection(url,username,password)){
            String sql = "SELECT customer_id, first_name, last_name, country, postal_code, phone, email FROM "
                    + "customer WHERE last_name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,lastName);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("country"),
                        result.getString("postal_code"),
                        result.getString("phone"),
                        result.getString("email"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return customer;
    }

    public List<Customer> sortCustomersByLastName(){
        String sql = "SELECT * FROM customer ORDER BY last_name LIMIT 10 OFFSET 5;";
        List<Customer>customers = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url,username,password)) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Customer customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("country"),
                        result.getString("postal_code"),
                        result.getString("phone"),
                        result.getString("email")
                );
                customers.add(customer);
                System.out.println(customer);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return customers;
    }



}



