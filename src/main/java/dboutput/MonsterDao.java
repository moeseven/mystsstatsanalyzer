package dboutput;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import csv_output.BaseSTSStats;
import csv_output.CardStatStats;
import csv_output.MonsterStrength;
import csv_output.RunDataStats;
import mystsstatsanalyser.MonsterStat;

public class MonsterDao extends StsStatDao {

	public MonsterDao() {
		super("Monsters");
	}

	public void insertMultipleRows(List<BaseSTSStats> dataList) {
		 String sql = "INSERT INTO "+table_name+"(character, monster, type, actname, act, avgdamage, avgfightduration, killrate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		 int batchSize = 1000;
		 int count = 0;
		 try (
				 Connection conn = STSDBConnection.getConnection();
			 
				 PreparedStatement stmt = conn.prepareStatement(sql)) {
				 for(BaseSTSStats item : dataList) {
					if (item instanceof MonsterStrength monsterStat) {
						stmt.setString(1, monsterStat.getCharacter());
						stmt.setString(2, monsterStat.getMonster());
						
						stmt.setString(3, monsterStat.getType());
						stmt.setString(4, monsterStat.getAct());
						stmt.setInt(5, monsterStat.getAct_number());
						stmt.setDouble(6, monsterStat.getAvg_damage_done());
						stmt.setDouble(7,monsterStat.getAvg_fight_duration());
						stmt.setDouble(8, monsterStat.getKill_rate());
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
