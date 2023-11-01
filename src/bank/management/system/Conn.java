package bank.management.system;
import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    public Conn() {
        try {
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hsbc", "root", "root");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
