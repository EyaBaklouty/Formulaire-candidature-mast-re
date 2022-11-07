package master;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;

public class ConnexionBD {



 private static Connection connection;
private ConnexionBD() {
try {

Class.forName("com.mysql.jdbc.Driver");
connection=DriverManager.getConnection("jdbc:mysql://localhost/mastere","root","");
System.out.println("connexion établi...");

}
catch(ClassNotFoundException e) {
System.out.println("Probleme chargement pilote...");
e.printStackTrace();
}
catch(SQLException e)
{
System.out.println("Probleme etablissement connexion...");
e.printStackTrace();
}

}

public static Connection getConnection() {
if(connection==null)
new ConnexionBD();
return connection;

}
}

