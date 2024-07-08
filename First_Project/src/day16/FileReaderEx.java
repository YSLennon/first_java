package day16;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderEx {

	public static void main(String[] args) throws IOException {

		int c;
		FileReader reader = new FileReader("file/helloworld.txt");
//		FileReader reader = new FileReader("file/system.ini");
//		FileReader reader = new FileReader("C:/windows/system.ini");
		
		while((c = reader.read()) != -1) {
			System.out.print((char)c);
		}
		
		reader.close();
		
		FileWriter writer = new FileWriter("file/helloworld.txt");
		
		
		
	}

}
