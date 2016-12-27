package _00.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sample {

	public static void main(String args[]) {
		List<String> symbols = Arrays.asList("GOOG", "AAPL", "MSFT", "INTC");

		ArrayList<Object> symbolsLowerCase = new ArrayList<>();
		for (String symbol : symbols) {
			symbolsLowerCase.add(symbol.toLowerCase());
		}

		System.out.println(symbolsLowerCase);
		
		System.out.println(
				symbols.stream()
						.map(String::toLowerCase)
						//.filter(symbol -> symbol.startsWith("g")) //passing functions as first class citizen
						.collect(Collectors.toList())
						//.findFirst() //lazy evaluation
				);
	}
}