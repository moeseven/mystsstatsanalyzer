package csv_output;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvWriter {
	
	
	
	
	
	public CsvWriter(Path writePath) {
		super();
		this.writePath = writePath;
	}


	private Path writePath;


	public void writeStats(String file, List<BaseSTSStats> stat_list)throws IOException {
		try (BufferedWriter writer = Files.newBufferedWriter(writePath.resolve(file+ ".csv"))) {

            // header
            writer.write(stat_list.getFirst().headerRow());
            writer.newLine();

            // rows
            for (BaseSTSStats card : stat_list) {
                writer.write(card.toString());
                writer.newLine();
            }
        }
	}
}
