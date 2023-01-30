import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Procedimiento1 {
    public static void Procedimiento1() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo?serverTimeZone=UTC","root","afuera");

        String sql = "{call altaEmpleado(?,?,?,?,?)}";
        CallableStatement llamada = conex.prepareCall(sql);

        llamada.setString(1,"Alonso");
        llamada.setString(2,"C/Ramon y Cajal 31");
        llamada.setString(3,"2022-09-15");
        llamada.setFloat(4,(float) 2000.00);
        llamada.setShort(5,(short) 110);

        llamada.executeUpdate();

        llamada.close();
        conex.close();




    }
}
