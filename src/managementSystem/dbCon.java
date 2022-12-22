package managementSystem;
import java.sql.*;

public class dbCon {
    //create connection

    Connection c;
    Statement s;
    public dbCon(){
        //SQL is an external entity, thus need try and catch
        try {
            c = DriverManager.getConnection("jdbc:mysql:///tunetrades","root","Adil1234");
            s = c.createStatement();
        }
        catch (Exception e){
            System.out.println(e);

        }
    }
}
