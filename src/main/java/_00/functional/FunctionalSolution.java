package _00.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalSolution {

	public static void main(String args[]) {
		List<String> symbols = Arrays.asList("GOOG", "AAPL", "MSFT", "INTC");

		// Imperative
		ArrayList<Object> symbolsLowerCase = new ArrayList<>();
		for (String symbol : symbols) {
			symbolsLowerCase.add(symbol.toLowerCase()); // -> mutability
		}

		// When someone asks you to take this code and make it concurrent you
		//probably run to the nearest exit because making imperative code
		//concurrent is hard

		System.out.println(symbolsLowerCase);
		
		// Functional
		System.out.println(
				symbols.stream()
						.map(String::toLowerCase)
						// (1) function pipeline 
						//.filter(symbol -> symbol.startsWith("g"))
						.collect(Collectors.toList())
						//.findFirst() // (2) lazy evaluation (terminal operation)
				);
		/*
		 * making functional code concurrent is relatively easy
		 * replace stream(), with parallelStream()
		 */

	}
}
