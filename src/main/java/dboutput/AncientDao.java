package dboutput;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import csv_output.AncientChoiceStats;
import csv_output.BaseSTSStats;
import csv_output.CardStatStats;
import csv_output.MonsterStrength;
import csv_output.RelicStats;
import csv_output.RunDataStats;
import mystsstatsanalyser.MonsterStat;

public class AncientDao extends StsStatDao {

	public AncientDao() {
		super("Ancients");
	}

	public void insertMultipleRows(List<BaseSTSStats> dataList) {
		 String sql = "INSERT INTO "+table_name+"(character, ancient, ancientbonus, winrate, pickrate, wincontribution, pickelo) VALUES (?, ?, ?, ?, ?, ?, ?)";
		 int batchSize = 1000;
		 int count = 0;
		 try (
				 Connection conn = STSDBConnection.getConnection();
			 
				 PreparedStatement stmt = conn.prepareStatement(sql)) {
				 for(BaseSTSStats item : dataList) {
					if (item instanceof AncientChoiceStats ancientStat) {
						stmt.setString(1, ancientStat.getCharacter());
						stmt.setString(2, ancientStat.getAncient());
						
						stmt.setString(3, ancientStat.getAncient_bonus());
						stmt.setDouble(4, ancientStat.getWin_rate());
						stmt.setDouble(5, ancientStat.getPick_rate());
						stmt.setDouble(6, ancientStat.getWin_contribution());
						stmt.setInt(7, ancientStat.getPick_elo());

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
