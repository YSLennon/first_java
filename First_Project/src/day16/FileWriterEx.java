package day16;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterEx {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		int c;
		FileWriter writer = new FileWriter("file/helloworld.txt");

		
		while(true) {
			String line = scanner.nextLine();
			if(line.length() == 0) break;
			
			writer.write(line, 0, line.length());
			writer.write("\r\n", 0, 2);
		}
		scanner.close();
		writer.close();
		
		

	}

}
