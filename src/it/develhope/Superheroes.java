package it.develhope;

import java.sql.*;

public class Superheroes {


    final String url = "jdbc:mysql://localhost:3306/superheroes";
    final String user = "root";
    final String password = "admin";


    public void createTable(){
        try {
            Connection conn = null;
            conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            String queryCreate = "CREATE TABLE IF NOT EXISTS superheroes(" +
                    "hero_id int(10) NOT NULL AUTO_INCREMENT, " +
                    "name varchar(30), " +
                    "teams varchar(30), " +
                    "power varchar(30), " +
                    "PRIMARY KEY(hero_id))";
            statement.executeUpdate(queryCreate);
            System.out.println("Table created");
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void insertHero(String name, Teams teamName){
        try {
            Connection conn = null;
            conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            String insertQuery = """ 
                    INSERT INTO superHeroes (name, teams)
                    VALUE ('""" + name + "', '" + teamName.getTeamName() + "');";
            statement.executeUpdate(insertQuery);
            System.out.println("Hero entered");
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void printAllHeroes(){
        try {
            Connection conn = null;
            conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            String printHero = "SELECT * FROM superheroes";
            ResultSet resultSet = statement.executeQuery(printHero);
            while (resultSet.next()) {
                System.out.print(resultSet.getString("name") + ", ");
                System.out.print(resultSet.getString("teams") + ", ");
                System.out.println(resultSet.getString("power"));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void updateHero(){
        try {
            Connection conn = null;
            conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            String updateHero = "SELECT * FROM superheroes";
            ResultSet resultSet = statement.executeQuery(updateHero);
            String findName = null;
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String team = resultSet.getString("teams");
                if (team.equals(Teams.XMEN.getTeamName())) {
                    findName = name;
                }
                String update = "UPDATE superheroes SET power='high' WHERE name = " + " '" + findName + "' ";
                PreparedStatement updateHer = conn.prepareStatement(update);
                updateHer.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void dropTable(){
        try {
            Connection conn = null;
            conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            String queryCreate = "DROP TABLE superheroes";
            statement.executeUpdate(queryCreate);
            System.out.println("Table dropped");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}