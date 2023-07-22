package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
/**
 * This class utilizes two methods to create a TreeMap containing the number of occurrence
 * and also writes the data to a file with fileWriter.
 *
 */

public class AnalyticsCounter extends ReadSymptomDataFromFile {
	private String outputFile;
	private String inputFile;


	/**
	 *Constructor to initialize inputFile and outputFile
	 *
	 */
	public AnalyticsCounter(String inputFile, String outputFile){
		// Call the constructor of the superclass ReadSymptomDataFromFile to read symptom data from inputFile
		super(inputFile);
		this.inputFile = inputFile;
		this.outputFile = outputFile;

	}

	/**
	 * Method to organize symptoms and count occurrences using a TreeMap
	 *
	 */
	public TreeMap<String, Integer> symptomOrganiser() {
		// Read symptoms from the input file using the ReadSymptomDataFromFile class
		ArrayList<String> fileSymptoms = (ArrayList<String>) new ReadSymptomDataFromFile(inputFile).GetSymptoms();
		TreeMap<String, Integer> mapSymptomCounter = new TreeMap<>();
		// Count occurrences of each symptom and store them in the mapSymptomCounter TreeMap
		for (String element : fileSymptoms) {
			mapSymptomCounter.put(element, mapSymptomCounter.getOrDefault(element, 0) + 1);
		}
		return mapSymptomCounter;// Return the TreeMap containing symptom counts
	}

	/**
	 *Method to write the symptom counts to the outputFile
	 *
	 */
	public void fileWriter(TreeMap<String, Integer> symptomCounterWriter) throws IOException {
		FileWriter writer = new FileWriter(outputFile);
		String fileContent;
		// Write the symptom counts to the output file
		for (Map.Entry<String, Integer> entry : symptomCounterWriter.entrySet()) {
			if (entry.getValue() > 1) {
				fileContent =   entry.getKey() + " = " + entry.getValue() + "\n";
				writer.write(fileContent);
			}
		}
		writer.close();
	}
}
