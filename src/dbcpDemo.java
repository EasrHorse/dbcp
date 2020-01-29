import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbcpDemo {

        public static DataSource getDataSource_dbcp(){
            BasicDataSource dbcp=new BasicDataSource();
            dbcp.setDriverClassName("com.mysql.cj.jdbc.Driver");
dbcp.setUrl("jdbc:mysql://localhost:3306/mxd");
dbcp.setUsername("root");
dbcp.setPassword("@#MA847547125**");
        dbcp.setInitialSize(20);//初始链接数量
            dbcp.setMaxActive(10);//最大活动数量10
            return dbcp;//拿到dbcp连接池
        }


    public static void main(String[] args) throws SQLException {
        //dbcp.c3p0都是数据源
        Connection connection = getDataSource_dbcp().getConnection();
        PreparedStatement preparedStatement =connection.prepareStatement("select * from person");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            System.out.println(resultSet.getInt(1)+resultSet.getString(2)+resultSet.getInt(3));

        }

    }
}
