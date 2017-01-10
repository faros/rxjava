package rxjava._02.controlling.solution;

import rx.Observable;

public class MyRXJava {

	public static void main (String args[]) {
		Observable<String> feed = DataGenerator.getFeed();
		System.out.println("got observable");
		
		feed.subscribe(System.out::println,
						System.out::println,
						() -> System.out.println("done"));
	}
}
