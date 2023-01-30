import java.sql.*;

public class Procedimiento3 {
    public static void Procedimiento3() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo?serverTimeZone=UTC","root","afuera");

        String sql = "{call obtenerDepList(?,?,?)}";
        CallableStatement llamada = conex.prepareCall(sql);

        llamada.registerOutParameter(1, Types.VARCHAR);
        llamada.registerOutParameter(2,Types.CHAR);
        llamada.registerOutParameter(3,Types.DECIMAL);

        llamada.execute();

        System.out.println(llamada.getString(1)+"|"+llamada.getString(2)+"|"+llamada.getString(3));
        llamada.close();
        conex.close();
    }
}
