import java.sql.*;
import java.util.Locale;
import java.util.Properties;

/**
 * Created by Alexandr on 17.04.2016.
 */
public class DBconnection
{
    private String root;
    private String password;
    private String url;

    private Connection oracleConnection;

    public DBconnection(String root, String password)
    {
        this.root = root;
        this.password = password;
        url = "jdbc:oracle:thin:@localhost:1521:xe";

        System.out.println("URL: " + url);
    }

    public void init()
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Locale.setDefault(Locale.ENGLISH);
            oracleConnection = DriverManager.getConnection(url, root, password);
            Locale.setDefault(Locale.getDefault());
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void finiliaze()
    {
        try {
            oracleConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet selectQuery(String text)
    {
        ResultSet resultSet=null;
        try {
            Statement statement = oracleConnection.createStatement();
            resultSet = statement.executeQuery(text);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void updateQuery(String text)
    {
        try {
            Statement statement = oracleConnection.createStatement();
            statement.executeUpdate(text);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
