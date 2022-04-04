package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private Connection connection; //make final
    private Statement stmt;
    private String databaseName = "Monicas.db";
    private final String url = "jdbc:sqlite:"+databaseName;

    Database() {
        connection = null; //move to final and add throws clause to database constructor
        stmt = null;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //UPDATESTATEMENT

    //prepared SQL-exequteUpdate
    public void DbsqlUpdate(String SQLUpdate){
        try{
            Statement sta = connection.createStatement();
            sta.executeUpdate(SQLUpdate);
            sta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Install database
    public void InstallDatabase(){
        Database d =new Database();
        if (d.connection == null) {  //todo er altid not null
            DbsqlUpdate("CREATE DATABASE "+url);
            System.out.println("Database opretet");
        }
    }

    public void createTable() { //Ret på columns
        try {
            String sql = "CREATE TABLE IF NOT EXISTS USER(\n"
                    + " name TEXT NOT NULL,\n"
                    + "	address TEXT NOT NULL,\n"
                    + "	email TEXT PRIMARY KEY,\n"
                    + "	mobileNr INTEGER NOT NULL,\n"
                    + "	accountNr TEXT NOT NULL, \n"
                    + "	checkDigits TEXT NOT NULL, \n"
                    + "	expirationDate_M TEXT NOT NULL, \n"
                    + "	expirationDate_y TEXT NOT NULL, \n"
                    + "	code TEXT NOT NULL, \n"
                    + " wealth INTEGER NOT NULL"
                    + ");";

            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
