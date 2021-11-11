package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("/Users/imrannjohn/Documents/Workspace-eclipse/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt"));
		String line = reader.readLine();
		
		// -------- Pour améliorer le programe je peut mettre un switch pour factoriser le code --------
		
		//int i = 0;	// set i to 0
		int headCount = 0;	// counts headaches
		while (line != null) {
			//i++;	// increment i
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				//System.out.println("number of headaches: " + headCount);
			}
			
			//Modifiaction de rush par rash OK@
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			 //Je pense que cette ligne ne sert a rien -> 
			line = reader.readLine();	// get another symptom
		}
		
		try (// next generate output
		FileWriter writer = new FileWriter ("resultat.out")) {
			// Modification de headacheCount par headCount
			writer.write("headache: " + headCount + "\n");
			
			writer.write("rash: " + rashCount + "\n");
			writer.write("dialated pupils: " + pupilCount + "\n");
			//writer.close();
		}
	}
	
}
 