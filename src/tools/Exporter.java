package tools;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import manager.ImportException;
import manager.InventoryTracker;

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

	private static InventoryTracker importSerializedFile() throws FileNotFoundException,
													IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("serializedModel.tmp");
		ObjectInputStream ois = new ObjectInputStream(fis);

		InventoryTracker it = (InventoryTracker)ois.readObject();
		ois.close();
		return it;
	}

	private static void exportToSQL(String filename) {
		
	}

	private static void exportToXML(String filename) throws FileNotFoundException, IOException,
													ClassNotFoundException, ExportException {
		InventoryTracker it = importSerializedFile();
		if (it == null) {
			new ExportException("InventoryTracker is null!");
		}

		BufferedWriter out = new BufferedWriter(new FileWriter(filename));
		out.write(it.toXML());
		out.close();
	}

	public static void main(String[] args) {
		try {
			if(args.length == 1) exportToXML(args[0]);
			else if(args.length == 2 && args[0] == "-sql") exportToSQL(args[1]);
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
		catch (ExportException e) {
			System.out.println("Error exporting: " + e.getMessage());
		}
	}

}

