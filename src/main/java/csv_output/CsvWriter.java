package csv_output;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvWriter {
	
	public static final Path folder = Path.of("D:","game_related","Streaming","slaythespire");


	public static void writeStats(String file, List<BaseSTSStats> stat_list)throws IOException {
		try (BufferedWriter writer = Files.newBufferedWriter(folder.resolve(file))) {

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
