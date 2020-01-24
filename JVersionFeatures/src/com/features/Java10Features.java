package com.features;

import java.lang.Runtime.Version;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Java10Features {
	/*
	 * 
	 * 1. Versioning
	 * 2. Local variable type inference(var) - can be used in 3 ways. this can only be used as local variables.
	 * 3.
	 */
	
	
	public static void main(String[] args) {
		
		System.out.println("Java 10 Features");
		
		Version version = Runtime.version();
		System.out.println("feature" + version.feature());
		System.out.println("interim" + version.interim());
		System.out.println("update"+version.update());
		System.out.println("patch"+version.patch());
		
		//before Java 10
		List<String> listString = List.of("a","b");
		//Java 10
		var list = List.of("a","b");
		
		// Index of Enhanced For Loop
		for (var number : list) {
			System.out.println(number);
		}
		// Local variable declared in a loop
		for (var i = 0; i < listString.size(); i++) {
			System.out.println(listString.get(i));
		}
		
		//var is not a keyword, It’s a reserved type name
		//We can create a variable named “var”
		var var = 3;
		System.out.println(var);
		// Similarly var can be used as a name of method,package,class and interface
		
		/*
		 * Var limitations
		 * 1. cannot be used without initialization i.e var x;
		 * 2. can be reintialized var x=5; x=4; 
		 * 3. varibale cannot be null if used with var -> var x=null; ->error
		 * 4. lambdas, method references, and array initializers, will trigger an error
		 *   Eg : Invalid scenarios
		 *      var min = (a, b) -> a < b ? a : b;
		 *      var minimum = Math::min;
		 *      var nums = {1,2,3,4,5};
		 */
		
		
		
		/* 1. List, Map & Set Interfaces are added with a static copyOf(Collection) method. 
		 *    Its returns an unmodifiable List, Map or Set containing the entries provided
		 * 2. Collectors.toUnmodifiableList added
		 */
		List<String> a = new ArrayList<String>();
		a.add("a");
		a.add("b");
		List<String> list1 = List.copyOf(a);
		System.out.println(list1);
		//list1.add  -->error
		
		List<String> unmodified = a.stream().collect(Collectors.toUnmodifiableList());
		System.out.println(unmodified);
		//unmodified.add  -->error
	}
}
