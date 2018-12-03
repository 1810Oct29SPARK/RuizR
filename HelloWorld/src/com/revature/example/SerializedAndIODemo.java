package com.revature.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializedAndIODemo {

	public static void main (String[] args) {
			
		String filename = "src/serialized Things.txt";
			
	}
	
	//serialize an object and write it to a file
	static void serializeToFile(String filename, Object o) {
		try {
			// use a FileOutputStream to write serialized object to file
			FileOutputStream fileOut = new FileOutputStream(filename);
			// use ObjectOutputStream to serialize the object
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(o); // what actually does the serialization
			// close stream
			out.close();
			fileOut.close();
		} catch (FileNotFoundException f) {
			f.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
}
