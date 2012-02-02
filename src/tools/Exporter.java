package tools;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import manager.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class Exporter {
	
	private static void print(String message) {
		System.out.println(message);
	}
	
	private static void usage() {
		print("USAGE: java tools.Exporter [-sql] <data-file>");
	}

	private static InventoryTracker importSerializedFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("serializedModel.tmp");
		ObjectInputStream ois = new ObjectInputStream(fis);

		InventoryTracker it = (InventoryTracker)ois.readObject();
		ois.close();
		return it;
	}

	private static void exportFromSQL(String filename) {
		
	}

	private static void exportFromSerialized(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
		InventoryTracker it = importSerializedFile();
		InventoryTracker.inst(it);

		BufferedWriter out = new BufferedWriter(new FileWriter(filename));
		out.write(it.toXML());
		out.close();
		
		System.out.println("SUCCESS --> the serialized data has been saved to " + filename);
	}

	public static void main(String[] args) {
		try {
			if(args.length == 1) exportFromSerialized(args[0]);
			else if(args.length == 2 && args[0] == "-sql") exportFromSQL(args[1]);
			else usage();
		} catch (FileNotFoundException e) {
			System.out.println("Error - File not found: " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
		catch (ClassNotFoundException e) {
			System.out.println("Error - Class not found because we are n00bs: " + e.getMessage());
		}
	}

}

