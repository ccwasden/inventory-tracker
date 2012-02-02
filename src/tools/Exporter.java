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

	private void importSerializedFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("serializedModel.tmp");
		ObjectInputStream ois = new ObjectInputStream(fis);

		InventoryTracker it = (InventoryTracker)ois.readObject();
		ois.close();

		BufferedWriter out = new BufferedWriter(new FileWriter("model.xml"));
		out.write(it.toXML());
		out.close();
	}

	public static void main(String[] args) {
		usage();
	}

}

