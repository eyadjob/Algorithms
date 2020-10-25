//package oldstudy.connecttodb;
//
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class EjarDb {
//
//    private static String strSql;
//    private static Statement stmtSQL;
//    private final String url = "jdbc:sqlserver://";
//    private final String serverName = "172.16.30.14\\sqlserver2017";
//    private final String port = ":1433";
//    private final String databaseName = "eJarDbTest959;";
//    private final String userName = "sa";
//    private final String password = "Wefaq@123";
//    private final String selectMethod = "cursor";
//    private java.sql.Connection con = null;
//
//    public static void main(String[] args) {
//
//        String[] columns = {"id"};
//
//        EjarDb ejarDb = new EjarDb();
//        ejarDb.getConnection();
//        List<String> result = ejarDb.getNewVehicles("SELECT * FROM eJarDbTest959.Fleet.Vehicles WHERE plateNo LIKE 'perf%' AND statusId='147';" , columns);
//        System.out.println(result);
//    }
//
//    private java.sql.Connection getConnection() {
//        try {
//
//            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
//            System.out.println(getConnectionUrl());
//
//            con = java.sql.DriverManager.getConnection(getConnectionUrl(), userName, password);
//            if (con != null) {
//                System.out.println("Connection Successful!");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Error Trace in getConnection() : " + e.getMessage());
//        }
//        return con;
//    }
//
//
//    private String getConnectionUrl() {
//        String connectionString = url + serverName + ";databaseName=" + databaseName;
//        System.out.println("connection String is : " + connectionString);
//        return connectionString;
//
//
//    }
//
//    public List<String> getNewVehicles(String query, String... columns) {
//
//        ResultSet resultSet = getResultSet(query);
//        List<String> strData = new ArrayList<String>();
//        try {
//
//            while (resultSet.next()) {
//
//                StringBuilder columnQuery = new StringBuilder();
//                for (String s : columns) {
//                    columnQuery.append(resultSet.getString(s) + ";");
//
//                }
//
//                strData.add(columnQuery.toString());
//            }
//            return strData;
//
//        } catch (Exception e) {
//            System.out.println(e.getCause());
//        } finally {
//            closeConnection();
//        }
//        return strData;
//
//    }
//
//    public ResultSet getResultSet(String query) {
//        java.sql.DatabaseMetaData dm = null;
//        java.sql.ResultSet rs = null;
//        try {
//            con = this.getConnection();
//            if (con != null) {
//                dm = con.getMetaData();
//                rs = dm.getCatalogs();
//                // Show all databases within the connection.
//                while (rs.next()) {
//                    System.out.println("\tcatalog: " + rs.getString(1));
//                }
//                rs.close();
//
//                stmtSQL = con.createStatement();
//
//                System.out.println("query is : " + query);
//                ResultSet rs1 = stmtSQL.executeQuery(query);
//
//                return rs1;
//
//            } else {
//                System.out.println("Error: No active Connection");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//        return null;
//    }
//
//
//    private void closeConnection() {
//        try {
//            if (con != null) {
//                con.close();
//            }
//            con = null;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//}
