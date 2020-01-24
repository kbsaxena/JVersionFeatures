package com.features;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java12Features {
	
	/*
	 * 1. Switch Expressions
	 */
	
	
	public static void main(String[] args) throws Exception {
		/*
		 * 1. The new Syntax removes the need for break statement to prevent fallthroughs.
		 * Switch Expressions don’t fall through anymore.
		 * Furthermore, we can define multiple constants in the same label.
		 * default case is now compulsory in Switch Expressions.
		 * break is used in Switch Expressions to return values from a case itself.
		 * 
		 * 2. File.mismatch : return -1L if there is no mismatch Otherwise The position of the character in string
		 * 3. Teeing Collector - This collector has three arguments – Two collectors and a Bi-function.
		 *    All input values are passed to each collector and the result is available in the Bi-function.
		 */
		
		 //Switch need to be implemented
		
		Path p1 = Files.createTempFile("text1", ".txt");
		Path p2 = Files.createTempFile("text1", ".txt"); 
		
		Files.writeString(p1, "Hello\nHello");
		Files.writeString(p2, "Hello\nHorld");
		
		System.out.println(Files.mismatch(p1, p2));  //returns 7..as there is a mismatch at 7th character
		
		var average = Stream.of(1,2,3,4,5,6,7,8,9,10)
				            .collect(Collectors.teeing(
				            		Collectors.summingDouble(i -> i),
				            		Collectors.counting(),
			                        (sum, n) -> sum / n));
	    System.out.println(average);
	}
}
