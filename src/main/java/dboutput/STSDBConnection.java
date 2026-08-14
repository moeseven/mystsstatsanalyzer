package dboutput;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class STSDBConnection {
	
	private static final String URLPort = "jdbc:sqlserver://localhost:51883;"
            + "databaseName=MyStsStats;"
            + "encrypt=false;"
            + "trustServerCertificate=true;";
	
	
    private static final String URL = "jdbc:sqlserver://localhost\\MSSQLSERVER02;"
            + "databaseName=master;"
            + "integratedSecurity=true;"
            + "encrypt=false;"
            + "trustServerCertificate=true;";
    
    private static final String USER = "sts";
    private static final String PASSWORD = "stspw";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URLPort, USER, PASSWORD);
    }

}
