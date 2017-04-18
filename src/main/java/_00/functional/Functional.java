package _00.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Functional {

	public static void main(String args[]) {
		List<String> symbols = Arrays.asList("GOOG", "AAPL", "MSFT", "INTC");

		// Imperative
		ArrayList<Object> symbolsLowerCase = new ArrayList<>();
		for (String symbol : symbols) {
			symbolsLowerCase.add(symbol.toLowerCase()); // -> mutability
		}

		System.out.println(symbolsLowerCase);

		// Functional


	}
}