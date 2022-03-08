package it.tss.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try {

            String url = "jdbc:mariadb://localhost:3306";
            try ( Connection conn = DriverManager.getConnection(url, "tss", "ghiglieno")) {
                System.out.println("connessione ok");
                conn.setCatalog("DBScuola");
                Statement cmd = conn.createStatement();
                //try ( ResultSet rs = cmd.executeQuery("insert into t_corsi(titlocorso)values("Inglese")")) {
                //rs.setString("");
                
                try ( ResultSet rs = cmd.executeQuery("select * from t_corsi")) {
                    while (rs.next()) {
                        System.out.println("Id Corso: " + rs.getInt(1));
                        System.out.print("Titolo: " + rs.getString("titolocorso") + " ");
                        System.out.println("Costo: " + rs.getString("costo"));
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("ERRORE" + e);
        }

    }
}
