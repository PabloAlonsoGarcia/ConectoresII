import java.sql.*;

public class Funcion1 {
    public static void Funcion1() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo?serverTimeZone=UTC","root","afuera");

        String sql = "{?=call obtenerDep }";
        CallableStatement llamada = conex.prepareCall(sql);

        llamada.registerOutParameter(1, Types.VARCHAR);

        llamada.execute();

        System.out.println(llamada.getString(1));


        llamada.close();
        conex.close();





    }
}
