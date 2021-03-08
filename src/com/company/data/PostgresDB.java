package com.company.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDB implements IPostgresDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException{
        String URL="jdbc:postgresql://localhost:5432/endterm";
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL,"postgres","0000");
        }
        catch (ClassNotFoundException | SQLException error){
            error.printStackTrace();
            throw error;
        }
    }
}

