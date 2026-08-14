package dboutput;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import csv_output.BaseSTSStats;
import csv_output.RunDataStats;

public abstract class StsStatDao {

	protected String table_name;
	
	
	
	public StsStatDao(String table_name) {
		super();
		this.table_name = table_name;
	}


	public void deleteAllEntries() {
		String sql = "DELETE FROM "+ table_name;

		try (PreparedStatement pstmt = STSDBConnection.getConnection().prepareStatement(sql)) {

		    int results = pstmt.executeUpdate();
		    System.out.println("Gelöscht: " + results + " Zeilen");
		    
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	}
	
	
	public abstract void insertMultipleRows(List<BaseSTSStats> dataList);


}
