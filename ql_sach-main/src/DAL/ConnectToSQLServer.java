package DAL;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectToSQLServer {
    private static SQLServerDataSource ds = null;

    public static Connection getConnection() throws SQLException {
        if (ds == null) {
            ds = new SQLServerDataSource();
            //ds.setServerName("THANHTUNG\\MSSQLSERVER01"); // Chỉ tên máy chủ
            ds.setServerName("localhost");
            //ds.setInstanceName("MSSQLSERVER01"); // Tên instance
            ds.setUser("sa");
            ds.setPassword("123456");
            ds.setDatabaseName("QL_SACH");
            ds.setPortNumber(1433);
            // KHÔNG đặt port nếu dùng dynamic port            
            ds.setTrustServerCertificate(true);     // Chấp nhận chứng chỉ tự ký (self-signed)
            ds.setIntegratedSecurity(false);
        }
        return ds.getConnection();
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            System.out.println("Connection success!");
            System.out.println(conn.getCatalog());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
