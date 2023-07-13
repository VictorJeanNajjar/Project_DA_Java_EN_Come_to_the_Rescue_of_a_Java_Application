package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsCounter {
	/*private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0*/
	
	public static void main(String args[]) throws Exception {
		// first get input
		//BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		//String line = reader.readLine();
		ArrayList<String> fileSymptoms = (ArrayList<String>) new ReadSymptomDataFromFile("symptoms.txt").GetSymptoms();

		/**
		 // int i = 0;	// set i to 0
		 //int headCount = 0;	// counts headaches// created a local varialble for no reason
		 while (line != null) {
		 i++;	// increment i
		 System.out.println("symptom from file: " + line);
		 if (line.equals("headache")) {
		 headacheCount++;
		 //System.out.println("number of headaches: " + headacheCount);
		 }
		 else if (line.equals("rash")) {//typo
		 rashCount++;
		 }
		 else if (line.contains("pupils")) {//doesnt account for multiple pupil symptoms
		 pupilCount++;
		 }

		 line = reader.readLine();	// get another symptom
		 */
		Map<String, Integer> SymptomCounter = new HashMap<>();
		for (String element : fileSymptoms) {
			SymptomCounter.put(element, SymptomCounter.getOrDefault(element, 0) + 1);
		}

		String fileContent = "please fill empty list";
		for (Map.Entry<String, Integer> entry : SymptomCounter.entrySet()) {
			FileWriter writer = new FileWriter("result.out");
			if (entry.getValue() > 1) {
				fileContent = "Symptom: " + entry.getKey() + ", Number: " + entry.getValue();
				writer.write(fileContent);
			}
			writer.close();
		}


		/* next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");// doesnt use the second variable that he used this one was still 0
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();*/
	}
}
