package dboutput;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import csv_output.AncientChoiceStats;
import csv_output.BaseSTSStats;
import csv_output.CardStatStats;
import csv_output.CharacterCollectedStats;
import csv_output.MonsterStrength;
import csv_output.RelicStats;
import csv_output.RunDataStats;
import mystsstatsanalyser.MonsterStat;

public class CharacterDao extends StsStatDao {

	public CharacterDao() {
		super("CharacterStats");
	}

	public void insertMultipleRows(List<BaseSTSStats> dataList) {
		 String sql = "INSERT INTO "+table_name+"(character, avgfloorreached, winrate, underdocksfloor, underdockswinrate, overgrowthfloor, overgrowthwinrate) VALUES (?, ?, ?, ?, ?,?,?)";
		 int batchSize = 1000;
		 int count = 0;
		 try (
				 Connection conn = STSDBConnection.getConnection();
			 
				 PreparedStatement stmt = conn.prepareStatement(sql)) {
				 for(BaseSTSStats item : dataList) {
					if (item instanceof CharacterCollectedStats characterStat) {
						stmt.setString(1, characterStat.getCharacter());
						stmt.setDouble(2, characterStat.getFloor_reached_avg());
						
						stmt.setDouble(3, characterStat.getWinRate());
						
						stmt.setDouble(4, characterStat.getFloor_reached_start_underdocks());
						stmt.setDouble(5, characterStat.getWinRate_underdocks());
						
						stmt.setDouble(6, characterStat.getFloor_reached_start_overgrowth());
						stmt.setDouble(7, characterStat.getWinRate_owergrowth());

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


}
