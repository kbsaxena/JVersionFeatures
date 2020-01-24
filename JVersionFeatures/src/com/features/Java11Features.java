package com.features;

import java.nio.file.Files;
import java.nio.file.Path;

public class Java11Features {
	/*
	 * 1. Running Java File with single command. no need of javac command, directly use java command
	 * 2. String methods - isBlank(), lines(), strip(), stripLeading(), stripTrailing(), repeat(int)
	 * 3. local variable var can be used in lambda as well
	 * 4. Reading/Writing Strings to and from the Files - readString() & writeString()
	 * 5. Nashorn JavaScript script engine and APIs are deprecated
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("Java 11 Features");
		
		/*
		 * String methods
		 */
		String s1 = "", s2="KB";
		System.out.println("is S1 blank : "+ s1.isBlank() + " and S2 : " + s2.isBlank()); //Returns true if the string is empty or contains only white space,otherwise false.
		
		s1 = "Hello\nWorld\n";
		System.out.println(s1.lines().count()); // scans via line seperator (\n)
		
		/*
		 * strip() is “Unicode-aware” evolution of trim()
		 */
		s1="     Hello     ";
		s2="World";
		System.out.println(s1.stripLeading()+s2);
		System.out.println(s1.stripTrailing()+s2);
		System.out.println(s1.strip()+s2);
		
		System.out.println(s2.repeat(5));
		
		//(var s1, s2) -> s1 + s2 //no skipping allowed
		//(var s1, String y) -> s1 + y //no mixing allowed
		//var s1 -> s1 //not allowed. Need parentheses if you use var in lambda.
		
		Path f = Files.createTempFile("text", ".txt");
		System.out.println(f.toString());
		Files.writeString(f, "Hello World"+System.lineSeparator()+"This is Java");
		String s = Files.readString(f);
		System.out.println(s);
		
		
	}
}
