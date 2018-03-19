package main.start;
/**
 * Java Application connect to Database via JDBC
 */

//STEP 1. Import required packages
import java.sql.*;

/**
 * @description:Java Application connect to Database via JDBC
 * @author: Admin
 * @time: 9:27:06 PM
 * @date: Mar 6, 2018
 */
public class JavaMainJDBC {
	static boolean isSqlDriver = true;
	// for MS-SQL Server
	// JDBC driver name and database URL
	static String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static String userName = "";
	static String passWord = "";
	static String URL = "jdbc:sqlserver://localhost:1433"
			+ ";instance=SQLEXPRESS;databaseName=CSD-RDC;integratedSecurity=true;";

	// for MySQL
	static String DriverMySQL = "com.mysql.jdbc.Driver";
	private static String DB_URL = "jdbc:mysql://localhost:3306/csd-rdc";
	private static String USER_NAME = "root";
	private static String PASSWORD = "123654";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			if (isSqlDriver) {
				// STEP 2: Register JDBC driver
				Class.forName(Driver);
				// STEP 3: Open a connection
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(URL, userName, passWord);
			} else {
				// STEP 2: Register JDBC driver
				Class.forName(DriverMySQL);
				// STEP 3: Open a connection
				conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			}

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM Student";
			ResultSet rs = stmt.executeQuery(sql);
			// stmt.executeUpdate("")

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("studentId");
				int age = rs.getInt("age");
				String fullName = rs.getString("fullName");
				String address = rs.getString("address");

				// Display values
				System.out.print("ID: " + id);
				System.out.print(", Age: " + age);
				System.out.print(", FullName: " + fullName);
				System.out.println(", Last: " + address);
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}// end main
}// end JavaMainJDBC
