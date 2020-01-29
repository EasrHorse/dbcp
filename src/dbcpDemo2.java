import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class dbcpDemo2 {

    public static DataSource getDBCP_properties() throws Exception {
        DataSource dbcp = null;
        Properties properties = new Properties();
        InputStream inputStream = new dbcpDemo2().getClass().getClassLoader().getResourceAsStream("dbcp.properties");
        //通过语法格式把文件变成输入流
        properties.load(inputStream);//加载
        dbcp = BasicDataSourceFactory.createDataSource(properties);
        return dbcp;
    }

    public static void main(String[] args) throws Exception {
        Connection connection = getDBCP_properties().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from person");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + resultSet.getString(2) + resultSet.getInt(3));

        }

    }

}

