package com.floridapublicnotices.commonUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataWriter {

	public static void write(String s) throws IOException {
		
		try {
			FileWriter fstream = new FileWriter("D:\\Florida Press Report\\Report.txt",true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(s);
			out.close();
		}
		catch (Exception e) {
			FileWriter fstream = new FileWriter("D:\\Report.txt",true);
			BufferedWriter out = new BufferedWriter(fstream);
			DataWriter.write(" "+"\n");
			out.write("Operation failed");
			out.close();
		}
	}
}
