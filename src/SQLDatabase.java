import java.sql.*;
import java.util.ArrayList;

public class SQLDatabase {
	String ConnectionURL;
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String SQL;
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
	public ArrayList<Object[]> executeSELECT(String SQL){
		setSQL(SQL);
		ArrayList<Object[]> output = new ArrayList<Object[]>();
		try {
			rs = stmt.executeQuery(getSQL());
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			Object[] header = new Object[columnCount];
			for(int i = 0; i<columnCount;i++ ){
				//System.out.println(rsmd.getColumnLabel(i+1));
				header[i] = rsmd.getColumnLabel(i+1);
			}
			output.add(header);
			while(rs.next()){
				Object[] rowData = new Object[columnCount];
				for(int i=0;i<columnCount;i++){
					rowData[i] =  rs.getObject(i+1);
				}
				output.add(rowData);
				//holder.add(getRowData(columnCount));
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

/*	private ArrayList<Record> getRecordSet(){
		ArrayList<Record> output = new ArrayList<Record>();
		ResultSetMetaData rsmd;
		try {

			rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			ArrayList<String[]> holder = new ArrayList<String[]>();
			String[] header = new String[columnCount];
			for(int i = 0; i<columnCount;i++ ){
				//System.out.println(rsmd.getColumnLabel(i+1));
				header[i] = rsmd.getColumnLabel(i+1);
			}
			holder.add(header);
			while(rs.next()){
				holder.add(getRowData(columnCount));
			}
			
			
			
			
			//output = new String[holder.size()][columnCount];
			//for (int x = 0;x <columnCount;x++){
			//for (int y = 0;y<holder.size();y++){
			//output[y][x] = holder.get(y)[x];
			//}
			//}
			return output;	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
	public Object[] getRowData(int columnCount){
		String[] rowData = new String[columnCount];
		try {
			for(int i=0;i<columnCount;i++){
				rowData[i] =  rs.getObject(i+1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowData;
	}*/

}
