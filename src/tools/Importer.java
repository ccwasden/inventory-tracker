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



public class Importer {
	
	private static void print(String message) {
		System.out.println(message);
	}

	private static void usage() {
		print("USAGE: java tools.Importer [-sql] <data-file>");
	}
	
	public static void main(String[] args) {
		if(args.length == 1) importToSerialize(args[0]);
		else if(args.length == 2 && args[0] == "-sql") importToSQL(args[1]);
		else usage();
	}
	
	public static void importToSerialize(String path){
		try {
			String fileContents = readFile(path);
//			String s = "<Smith><First_Name>Mary</First_Name><sex>Female</sex></Smith><Jackson><First_Name>Jackie</First_Name><sex>Female</sex></Jackson>";
			JSONObject json;
			try {
				json = XML.toJSONObject(fileContents);
				try {
					
					if(json.getJSONObject("inventory-tracker") == null) throw new ImportException("<inventory-tracker> tag not defined");
					InventoryTracker it = InventoryTracker.fromJSON(json.getJSONObject("inventory-tracker"));
					System.out.println("Successfully converted xml to obj. Implement serializing data to file");
				} catch (ImportException e) {
					// TODO Auto-generated catch block
					System.out.println("Error - Malformed XML: " + e.getMessage());
				}
			} catch (JSONException e) {
				System.out.println("Error parsing XML: " + e.getMessage());
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}
		
	public static void importToSQL(String path){
		System.out.println("implement import to sql");
	}

	private static String readFile(String path) throws IOException {
	  FileInputStream stream = new FileInputStream(new File(path));
	  try {
	    FileChannel fc = stream.getChannel();
	    MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
	    /* Instead of using default, pass in a decoder. */
	    return Charset.defaultCharset().decode(bb).toString();
	  }
	  finally {
	    stream.close();
	  }
	}
	
}

