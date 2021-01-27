package be.pxl.ja.containercup;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DeelnemerReader {
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("mm:ss");


	public static void main(String[] args) {
		FileSystem defaultFileSystem = FileSystems.getDefault();
		System.out.println(defaultFileSystem.getClass());
		for (Path rootDirs : defaultFileSystem.getRootDirectories()){
			System.out.println(rootDirs);
		}

		Path srcDir = Path.of(System.getProperty("user.dir"),"src");
		System.out.println(srcDir.toAbsolutePath());
		System.out.println(srcDir.getClass().getName());
		System.out.println(Files.isDirectory(srcDir));




		Path p1 = srcDir.resolve("main/resources/containercup.csv");
		Path path = Paths.get(String.valueOf(p1));
		readFile(path);

		try	{
			List<String> lijst = Files.readAllLines(path);
			System.out.println(lijst.size());
			System.out.println(lijst.get(5));

		}catch (IOException e){
			e.printStackTrace();
		}

	}
	// TODO implement static method for reading file
	public static void readFile(Path path){
		List<Deelnemer> deelnemers = new ArrayList<>();
		try	(BufferedReader reader = Files.newBufferedReader(path)){
			reader.readLine();
			String line = null;
			while ((line = reader.readLine()) != null){
				System.out.println(line);
				deelnemers.add(mapLineToDeelnemer(line));
				System.out.println(line.split(", ") + "   added to deelnemerslijst");
			}
		}catch (IOException e){
			e.printStackTrace();
		}
	}



	public static Deelnemer mapLineToDeelnemer(String line) {
		String[] split = line.split(";");
		Deelnemer deelnemer = new Deelnemer(split[0], Klassement.valueOf(split[9]));
		deelnemer.setLopen(parseDuration(split[2]));
		deelnemer.setMonkeyBars(Integer.parseInt(split[3]));
		deelnemer.setGolf(Integer.parseInt(split[4]));
		deelnemer.setRoeien(parseDuration(split[5]));
		deelnemer.setSchieten(Integer.parseInt(split[6]));
		deelnemer.setBenchpress(Integer.parseInt(split[7]));
		deelnemer.setFietsen(parseDuration(split[8]));
		return deelnemer;
	}

	private static Duration parseDuration(String duration) {
		duration = "PT" + duration.replace(":", "M") + "0S";
		return Duration.parse(duration);
	}

}
