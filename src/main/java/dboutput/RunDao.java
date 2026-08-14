package dboutput;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import csv_output.BaseSTSStats;
import csv_output.RunDataStats;

public class RunDao {

	private void insertList(List<BaseSTSStats> list) {
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			RunDataStats type = (RunDataStats) iterator.next();
			if (type instanceof RunDataStats rundata) {
				insert(rundata);
			}		
		}
	}
	
	public static void deleteAllEntries() {
		String sql = "DELETE FROM Runs";

		try (PreparedStatement pstmt = STSDBConnection.getConnection().prepareStatement(sql)) {

		    int results = pstmt.executeUpdate();
		    System.out.println("Gelöscht: " + results + " Zeilen");
		    
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	}
	
	
	public static void insertMultipleRows(List<BaseSTSStats> dataList) {
		 String sql = "INSERT INTO Runs(runId, character, won, floorReached, deathCause, act1, act2, act3) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		 int batchSize = 1000;
		 int count = 0;
		 try (
				 Connection conn = STSDBConnection.getConnection();
			 
				 PreparedStatement stmt = conn.prepareStatement(sql)) {
				 for(BaseSTSStats item : dataList) {
					if (item instanceof RunDataStats rundataStats) {
						stmt.setInt(1, rundataStats.getRun_id());
				        stmt.setString(2, rundataStats.getCharacter());
				        stmt.setBoolean(3, rundataStats.isWon());
				        stmt.setInt(4, rundataStats.getFloor_reached());
				        stmt.setString(5, rundataStats.getDeathCause());
				        stmt.setString(6, rundataStats.getAct1());
				        stmt.setString(7, rundataStats.getAct2());
				        stmt.setString(8, rundataStats.getAct3());
					}	
					stmt.addBatch();
					count++;
					if (count % batchSize == 0) {
						stmt.executeBatch();
		                System.out.println("Inserted " + count + " rows...");
		            }
				}
				 stmt.executeBatch();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

    public static void insert(RunDataStats rundataStats) {
        String sql =
            "INSERT INTO Runs(runId, character, won, floorReached, deathCause, act1, act2, act3) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = STSDBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, rundataStats.getRun_id());
            stmt.setString(2, rundataStats.getCharacter());
            stmt.setBoolean(3, rundataStats.isWon());
            stmt.setInt(4, rundataStats.getFloor_reached());
            stmt.setString(5, rundataStats.getDeathCause());
            stmt.setString(6, rundataStats.getAct1());
            stmt.setString(7, rundataStats.getAct2());
            stmt.setString(8, rundataStats.getAct3());

            stmt.executeUpdate();

            System.out.println("Run Data inserted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
