import java.sql.*;
import java.util.ArrayList;

public class SQLDatabase {
	private String ConnectionURL;
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private String SQL;
	public SQLDatabase(String connectionURL) {
		setConnectionURL(connectionURL);
	}
	public void setConnectionURL(String connectionURL) {
		ConnectionURL = connectionURL;
	}
	public String getSQL() {
		return SQL;
	}
	public void setSQL(String sQL) {
		SQL = sQL;
	}

	public boolean OpenSQLConnection(){//Opens the connection to the database. CLOSE ASAP!!!
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(ConnectionURL);
			stmt = con.createStatement();
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public void CloseSQLConnection(){//Standard Connection closing sequence
		if (rs != null)
			try {rs.close();} 
		catch (Exception e) {}
		if (stmt != null)
			try {stmt.close();}
		catch (Exception e) {}
		if (con != null)
			try {con.close();}
		catch (Exception e) {}
	}
	public Object[][] executeSELECT(String SQL){
		setSQL(SQL);
		Object[][] output = null;
		try {
			rs = stmt.executeQuery(getSQL());
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			String[] header = new String[columnCount];
			for(int i = 0; i<columnCount;i++ ){//Gets header data
				header[i] = rsmd.getColumnLabel(i+1);
			}
			//output.add(header);
			ArrayList<Object> holder = new ArrayList<Object>();
			while(rs.next()){
				for(Object columnName:header){
					holder.add(rs.getObject((String)columnName));
					//System.out.println(holder.get(holder.size()-1));
				}
			}
			//System.out.println(holder.size()/columnCount);
			
			output = new Object[columnCount][holder.size()/columnCount+1];
			for(int i = 0;i<header.length;i++){
				output[i][0] = header[i];
			}
			for(int i = 0;i<holder.size();i++){
				output[i%columnCount][(i/columnCount)+1] = holder.get(i);
				System.out.println(i%columnCount + " "+ (i/columnCount+1) +" "+holder.get(i));
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
	public void executeINSERT(String SQL){
		setSQL(SQL);
		try {
			stmt.executeUpdate(getSQL());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}