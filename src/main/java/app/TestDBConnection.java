package app;

import csv_output.RunDataStats;
import dboutput.RunDao;

public class TestDBConnection {
	public static void main(String[] args) {
		RunDataStats stats = new RunDataStats(0, "Ironclad", true, 49, "architect", "1", "test", "test");
		RunDao.insert(stats);
	}

}
