package dboutput;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import csv_output.BaseSTSStats;
import csv_output.CardStatStats;
import csv_output.RunDataStats;

public class CardsDao extends StsStatDao {

	public CardsDao() {
		super("Cards");
	}

	public void insertMultipleRows(List<BaseSTSStats> dataList) {
		 String sql = "INSERT INTO "+table_name+"(character, card, pickwinrate, pickrate, pickelo, wincontribution) VALUES (?, ?, ?, ?, ?, ?)";
		 int batchSize = 1000;
		 int count = 0;
		 try (
				 Connection conn = STSDBConnection.getConnection();
			 
				 PreparedStatement stmt = conn.prepareStatement(sql)) {
				 for(BaseSTSStats item : dataList) {
					if (item instanceof CardStatStats cardStat) {
						stmt.setString(1, cardStat.getCharacter());
						stmt.setString(2, cardStat.getCard());
						
						stmt.setDouble(3, cardStat.getWin_rate_picked());
						stmt.setDouble(4, cardStat.getPick_rate());
						stmt.setDouble(5, cardStat.getPick_elo());
						stmt.setDouble(6, cardStat.getCard_win_contribution());
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
