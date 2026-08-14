package dboutput;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import csv_output.BaseSTSStats;
import csv_output.CardStatStats;
import csv_output.MonsterStrength;
import csv_output.RelicStats;
import csv_output.RunDataStats;
import mystsstatsanalyser.MonsterStat;

public class RelicDao extends StsStatDao {

	public RelicDao() {
		super("Relics");
	}

	public void insertMultipleRows(List<BaseSTSStats> dataList) {
		 String sql = "INSERT INTO "+table_name+"(character, relic, winrate, wincontribution) VALUES (?, ?, ?, ?)";
		 int batchSize = 1000;
		 int count = 0;
		 try (
				 Connection conn = STSDBConnection.getConnection();
			 
				 PreparedStatement stmt = conn.prepareStatement(sql)) {
				 for(BaseSTSStats item : dataList) {
					if (item instanceof RelicStats relicStat) {
						stmt.setString(1, relicStat.getCharacter());
						stmt.setString(2, relicStat.getName());						
						stmt.setDouble(3, relicStat.getWin_rate());
						stmt.setDouble(4, relicStat.getWin_contribution());
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
