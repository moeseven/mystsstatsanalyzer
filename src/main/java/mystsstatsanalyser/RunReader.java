package mystsstatsanalyser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mystsstatsanalyser.jsonObjects.RunData;


public class RunReader {
	
	private static Path runHistoryFilePath = Path.of("C:","Users","Moritz","AppData","Roaming","SlayTheSpire2","steam","76561198070959178","profile1","saves","history");
	
	
	public ArrayList<RunData> readAllData() {
		List<Path> listOfFiles;
		ArrayList<RunData> runDataList = new ArrayList<RunData>();
		try {
			listOfFiles = Files.list(runHistoryFilePath)
	                .filter(Files::isRegularFile)
	                .sorted(Comparator.comparing(RunReader::lastModified))
	                .collect(Collectors.toList());
			System.out.println("number of runs: " + listOfFiles.size());
			for (Iterator iterator = listOfFiles.iterator(); iterator.hasNext();) {
				Path path = (Path) iterator.next();
				readFile(path).ifPresent(rd -> runDataList.add(rd));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return runDataList;
	}
	
	private static java.nio.file.attribute.FileTime lastModified(Path p) {
        try {
            return Files.getLastModifiedTime(p);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
	
	public Optional<RunData> readFile(String fileName){
		return readFile(runHistoryFilePath.resolve(fileName));
	}
	
	private Optional<RunData> readFile(Path filePath) {
		
		ObjectMapper mapper = new ObjectMapper();
		Optional<RunData> retVal = java.util.Optional.empty();
		//System.out.println(filePath.getFileName());
        try {
        	retVal = Optional.of(mapper.readValue(filePath.toFile(), RunData.class));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//System.err.print("failed");
		}
        return retVal;
	}

}
