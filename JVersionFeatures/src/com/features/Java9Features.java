package com.features;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java9Features {
	/*
	 * 1. List.of() => Creates Immutable list
	 *    similarly for Map and Set
	 * 2. private and private static method for segregating reusable code
	 * 3. No rt.jar and No tools.jar
	 * 4. module programing => module-nfo.java contains requires and imports
	 * 5. ProcessHandle interface added
	 * 6. Try With Resources Improvement
	 * 7. Stream interface introduced 2 new static methods iterate and ofNullable
	 *    and 2 default methods dropWhile and takeWhile
	 */	
	public static void main(String[] args) throws Exception {
		
		System.out.println("Java 9 Features");
		
		System.out.println(List.of(1,"b","c"));
		System.out.println(Set.of("a","b","c"));
		System.out.println(Map.of("a","b","c","d")); //key-a,value-b...key-c,value-d
		
		LoggingApp.DBlog();
		
		ProcessHandle currentProcess = ProcessHandle.current();
		System.out.println("Current Process Id: = " + currentProcess.pid());
		
		tryWithResources();
		
		//2 default methods
		/*
		 * takeswhile : does scanning sequentailly....stops if predicate becomes false in any step
		 * dropwhile : removes element sequentailly....stops if predicate becomes false in any step
		 * iterate : It is similar to for-loop: First parameter is init value, 
		 *          next parameter is condition and final parameter is to generate next element
		 * ofNullable() : returns a sequential Stream containing a single element, 
		 *            if non-null, otherwise returns an empty Stream
		 */
		Stream.of(1,2,3,4,5,6,7,8,9).takeWhile(p -> p<5).forEach(System.out::print);
		System.out.println();
		Stream.of(1,4,2,5).takeWhile(p -> p<3).forEach(System.out::println); //stopped at 4
		
		Stream.of(1,2,3,4,5,6,7,8,9).dropWhile(p -> p<5).forEach(System.out::print);
		System.out.println();
		Stream.of(1,4,2,5).dropWhile(p -> p<3).forEach(System.out::print);
		
		System.out.println();
		IntStream.iterate(1, x -> x < 20, x -> x+1).forEach(x->System.out.print(x));
		
	}
	
	
	public static void tryWithResources() throws Exception {
		/*Java 7/8 
		 * If Resource is already declared outside the Try-With-Resources Statement, 
		    we should re-refer with local variable
	     */
		 BufferedReader reader1 = new BufferedReader(new FileReader("dummy.txt"));
		 try (BufferedReader reader2 = reader1) {
		   System.out.println(reader2.readLine());
		 }
		 
		 /*
		  * In Java 9
		  * if we have a resource which is already declared outside the Try-With-Resource Statement as final or effectively final,
		  *  then we do NOT need to declare a local variable
		  */
		 BufferedReader reader = new BufferedReader(new FileReader("dummy.txt"));
		 try (reader) {
		   System.out.println(reader.readLine());
		 }
	}
}

interface LoggingApp {
	static void DBlog() {
		log("DBlog");
	}
	
	default void APPLog() {
		log("APPlog");
	}
	
	//method for reusable code
	private static void log(String log) {
		System.out.println("Logger in : " + log);
	}
}

