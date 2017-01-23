package rxjava1._05transforming;

import java.util.Arrays;
import java.util.List;

import rx.Observable;

/*
 * TODO 40 Transforming Observables with Operators
 * Rx allows you to chain operators together to transform and compose Observables
 */
public class Transforming {
	
	public static void main(String args[]) {
		List<String> fruit = Arrays.asList("lettuce", "cauliflower", "broccoli", "paprika", "apple", "strawberry", "kiwi", "orange", "pineapple", "fig", 
				"mango", "pear", "apricot", "banana", "blueberry", "grape", "melon", "Kumquat", "peach", "mandarine", "papaya", "passionfruit");

		/*
		 * TODO 41 : Create an Observable from the fruit list
		 */
		Observable<String> fruitFeed = Observable.from(fruit);

		/*
		 * TODO 42:  
		 * Some of the items in that list are not fruit at all. So get rid of them! 
		 * Also, we're only interested in fruit that starts with the letter p
		 * Transform the Observable, and subscribe to it, printing out the selected fruits.
		 */ 
		fruitFeed.skip(4)
				 .filter(s -> s.startsWith("p"))
			 	 .subscribe(System.out::println, System.out::println, () -> System.out.println("DONE"));
		
		/*
		 * TODO 43 : concatenate both Observables and print out.
		 */
		
		Observable<Integer> f1 = Observable.just(1, 2, 3, 4, 20, 65, 89, 900, 15, 100);
		Observable<Integer> f2 = Observable.just(5, 58,50, 1, 59, 968, 155);
		
		Observable.merge(f1, f2).subscribe(System.out::println);

		/*
		 * TODO 44 : only interested until the color starts with a "y", then stop.
		 */
		List<String> colors = Arrays.asList("green", "red", "green", "orange", "yellow", "purple", "yellow", "green");
		Observable<String> colorFeed = Observable.from(colors);
		
		colorFeed.takeWhile(s -> !s.startsWith("y")) // sends onComplete downstream & unsubscribe upstream
				.subscribe(System.out::println);
		
	}
}
