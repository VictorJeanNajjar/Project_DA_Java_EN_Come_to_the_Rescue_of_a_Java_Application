package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	/**
	 * Reads the symptom data from the specified file and returns a list of symptoms.
	 *
	 * @return A list of symptoms as strings. If no data is available or an error occurs, an empty list is returned
	 * since a blank list was defined in the ISymptomReader interface.
	 */
	@Override
	public List<String> GetSymptoms() {
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();

				// Read each line from the file and add it to the result list
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}

				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;// Return the list of symptoms
	}

}
