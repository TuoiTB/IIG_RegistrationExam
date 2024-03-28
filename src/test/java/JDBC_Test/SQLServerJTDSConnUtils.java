package JDBC_Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerJTDSConnUtils {
    public static Connection getSQLServerConnection() {
        String hostName = "10.11.10.13";
        String sqlInstanceName = "SQLEXPRESS";
        String database = "IIG.Core.Framework.EOS";
        String userName = "sa";
        String password = "IigDB#2021#";

        return getSQLServerConnection(hostName, sqlInstanceName, database, userName, password);
    }

    public static Connection getSQLServerConnection(String hostName, String sqlInstanceName, String database, String userName, String password) {
        Connection conn = null;
        try {
            // Khai báo class Driver cho SQLServer
            // Việc này cần thiết với Java 5
            // Java 6 tự động tìm kiếm Driver thích hợp - ko bắt buộc cần dòng này
            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            // Cấu trúc URL Connection dành cho SQL Server
            // Ví dụ:
            // jdbc:jtds:sqlserver://localhost:1433/automationfc;instance=SQLEXPRESS
            String connectionURL = "jdbc:jtds:sqlserver://" + hostName + ":1433/" + database + ";instance=" + sqlInstanceName;

            conn = DriverManager.getConnection(connectionURL, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}