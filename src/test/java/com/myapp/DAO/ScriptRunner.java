package com.myapp.DAO;

import com.myapp.DAO.DBConnection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Statement;

public class ScriptRunner extends DBConnection {

    public void executeScript() {
        String thisLine;
        String sqlQuery;
        String fileName = ".\\src\\test\\CoreJava\\Resources\\CoreJava_test.sql";
        Statement stmt;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            sqlQuery = "";
            while (br.ready()) {
                thisLine = br.readLine();
                //Skip comments and empty lines
                if (thisLine.length() == 0 || thisLine.charAt(0) == '-') {
                    continue;
                }
                sqlQuery = sqlQuery + " " + thisLine;
                //If one command complete
                if (sqlQuery.charAt(sqlQuery.length() - 1) == ';') {
                    sqlQuery = sqlQuery.replace(';', ' '); //Remove the ;
                    stmt.addBatch(sqlQuery);
                    try {
                        stmt.executeBatch();
                    } catch (Exception ex) {
                        System.out.println("Error Creating the SQL Database : " + ex.getMessage());
                    }
                    sqlQuery = "";
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file " + fileName + " is not found.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.dispose(conn, null, null);
        }
    }

    public void clearDB() {
        Statement stmt;
        String[] sqlQuery = {"DROP TABLE comments",
                "DROP TABLE comments",
                "DROP TABLE viewed_product",
                "DROP TABLE cart_detail",
                "DROP TABLE cart",
                "DROP TABLE order_detail",
                "DROP TABLE orders",
                "DROP TABLE order_state",
                "DROP TABLE product",
                "DROP TABLE brand",
                "DROP TABLE category",
                "DROP TABLE currency",
                "DROP TABLE users",
                "DROP TABLE role"
        };
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            for (String query : sqlQuery) {
                stmt.addBatch(query);
            }
            stmt.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.dispose(conn, null, null);
        }
    }
}
