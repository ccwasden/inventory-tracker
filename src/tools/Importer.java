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
		try {
			if(args.length == 1) importToSerialize(args[0]);
			else if(args.length == 2 && args[0] == "-sql") importToSQL(args[1]);
			else usage();
		} catch (ImportException e) {
			System.out.println("Error - Malformed XML: " + e.getMessage());
		}
		catch (JSONException e) {
			System.out.println("Error parsing XML: " + e.getMessage().replaceFirst("JSON", ""));
		}
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}
	
	public static void importToSerialize(String path) throws IOException, JSONException, ImportException{
		InventoryTracker it = getInventoryTrackerFromXMLFile(path);
		
		FileOutputStream fos = new FileOutputStream("serializedModel.tmp");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(it);
		oos.close();
	}
		
	public static void importToSQL(String path) {
		System.out.println("implement import to sql");
	}
	
	public static InventoryTracker getInventoryTrackerFromXMLFile(String path) throws IOException, ImportException, JSONException{
		String fileContents = readFile(path);
		JSONObject json;
		json = XML.toJSONObject(fileContents);
		
		if(json.getJSONObject("inventory-tracker") == null) throw new ImportException("<inventory-tracker> tag not defined");
		return InventoryTracker.fromJSON(json.getJSONObject("inventory-tracker"));
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

