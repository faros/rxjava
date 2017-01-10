package rxjava._05.transformingobservables.solution;

import rx.Observable;

public class MyRXJava {

	public static void main (String args[]) {
		Observable<String> feed = DataGenerator.getFeed();
		System.out.println("got observable");
		
		feed
			.map(s -> s.concat("--JEROEN"))
			.filter(s -> s.startsWith("0"))
			.take(5)
			.skip(5)
			.takeWhile(s -> !s.startsWith("e")) //sends onComplete downstream & unsubscribe upstream
			.subscribe(System.out::println, System.out::println,  () -> System.out.println("DONE"));
	}
}
