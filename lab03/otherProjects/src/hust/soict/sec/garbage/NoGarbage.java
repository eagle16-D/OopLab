package hust.soict.sec.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
	public static void main(String[] agrs) {
		String filename = "C:\\Users\\ADMIN\\eclipse-workspace\\otherProjects\\src\\hust\\soict\\sec\\garbage\\log_format.txt";
		byte[] inputBytes = { 0 };
		long startTime, endTime;
		
		try {
			inputBytes = Files.readAllBytes(Paths.get(filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		startTime = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for(byte b : inputBytes) {
			sb.append((char)b);
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}
