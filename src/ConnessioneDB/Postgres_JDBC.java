package ConnessioneDB;

import java.sql.*;
import java.util.Date;


public class Postgres_JDBC {
    public static void main(String[] args) {
        System.out.println("Ciao sono Ale");
        Connection conn_SQL = null;

        //istanzia la classe di connessione al DB

        ConnectionDB Connectiondb = ConnectionDB.getConnectionDB();

        //recupera la connessione
        conn_SQL = Connectiondb.getConnection();

        if (conn_SQL == null) {
            System.out.println("Connessione non RIUSCITA!");
            System.exit(0);
        }

        System.out.println("Connessione OK!");


        //LO STATEMENT CI SERVE PER ESEGUIRE QUERY

        Statement stmt = null;

        try {
            stmt = conn_SQL.createStatement();

            String comando4 = "SELECT * FROM registra";
            ResultSet rs = stmt.executeQuery(comando4);

            while (rs.next()) {
                int fkcorso = rs.getInt("fkcorso");
                String fkusername = rs.getString("fkusername");
                System.out.println("IDCorso: " + fkcorso + " Nome_Chef: " + fkusername + "");


            }

            rs.close();
            stmt.close();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
        }



    }
}
