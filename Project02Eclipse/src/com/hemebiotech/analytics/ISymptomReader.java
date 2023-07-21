package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;

/**
 * This interface represents a symptom reader, responsible for reading symptom data.
 * It provides a method to get a list of symptoms.
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	ArrayList<String> result = new ArrayList<String>();
	List<String> GetSymptoms ();
}
