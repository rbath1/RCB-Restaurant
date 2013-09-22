/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bob
 */
public class MenuDB implements IMenuDB {
    private Connection conn;
	private String driverClassName;
	private String url;
	private String userName;
	private String password;

	public MenuDB() {
        }
        
    @Override
        public void openConnection()throws IllegalArgumentException, ClassNotFoundException, SQLException{

		
		driverClassName = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/restaurant";
		userName = "root";
		password = "kerouac00";

		try {
			  Class.forName (driverClassName);
			  conn = DriverManager.getConnection(url, userName, password);
		}
		catch ( ClassNotFoundException cnfex ) {
		   System.err.println(
			  "Error: Failed to load JDBC driver!" );
		   cnfex.printStackTrace();
		   System.exit( 1 );  // terminate program
		}
		catch ( SQLException sqlex ) {
		   System.err.println( "Error: Unable to connect to database!" );
		   sqlex.printStackTrace();
		   System.exit( 1 );  // terminate program
		}
        }
    
        public void closeConnection() throws SQLException {
		conn.close();
	}
        
        public List findRecords(String sqlString, boolean closeConnection) 
	throws SQLException, Exception
	{
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData metaData = null;
		final List list=new ArrayList();
		Map record = null;

		// do this in an excpetion handler so that we can depend on the
		// finally clause to close the connection
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlString);
			metaData = rs.getMetaData();
			final int fields=metaData.getColumnCount();

			while( rs.next() ) {
				record = new HashMap();
				for( int i=1; i <= fields; i++ ) {
					try {
						record.put( metaData.getColumnName(i), rs.getObject(i) );
					} catch(NullPointerException npe) { 
						// no need to do anything... if it fails, just ignore it and continue
					}
				} // end for
				list.add(record);
			} // end while

		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				stmt.close();
				if(closeConnection) conn.close();
			} catch(SQLException e) {
				throw e;
			} // end try
		} // end finally

		return list; // will  be null if none found
	}
}
