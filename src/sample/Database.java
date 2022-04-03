package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private Connection connection; //make final
    private Statement stmt;
    private final String url = "jdbc:sqlite:D:\\IntelliJ Java projecter\\MonikaSalon\\Customers";

    Database() {
        connection = null; //move to final and add throws clause to database constructor
        stmt = null;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
